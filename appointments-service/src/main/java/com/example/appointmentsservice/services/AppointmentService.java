package com.example.appointmentsservice.services;

import com.example.appointmentsservice.model.Appointment;
import com.example.appointmentsservice.repositories.AppointmentRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment createAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    public void updateAppointment(Appointment appointment) {
        requireNonNullAppointmentId(appointment);
        requireAppointmentExists(appointment);

        repository.save(appointment);
    }

    public List<Appointment> findAll(Predicate predicate) {
        Iterable<Appointment> all = repository.findAll(predicate);
        List<Appointment> allList = new ArrayList<>();
        all.iterator().forEachRemaining(allList::add);
        return allList;
    }

    private void requireNonNullAppointmentId(Appointment appointment) {
        Objects.requireNonNull(appointment.getId());
    }

    private void requireAppointmentExists(Appointment appointment) {
        if (!repository.existsById(appointment.getId())) {
            throw new RuntimeException("Appointment doesn't exist!");
        }
    }

    @Scheduled(cron = "${appointment.fail.schedule}")
    private void failOverdueAppointments() {
        List<Appointment> failedAppointments = overdueAppointments().stream()
                .peek(appointment -> appointment.setStatus(Appointment.Status.FAILED))
                .collect(Collectors.toList());

        repository.saveAll(failedAppointments);
    }

    private List<Appointment> overdueAppointments() {
        return repository.findAppointmentByDateAndStatus(LocalDate.now(), Appointment.Status.PENDING);
    }

    public void cancelAppointment(Long id) {
        repository.deleteById(id);
    }
}
