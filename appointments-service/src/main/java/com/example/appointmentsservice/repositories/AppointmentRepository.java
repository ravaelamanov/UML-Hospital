package com.example.appointmentsservice.repositories;

import com.example.appointmentsservice.model.Appointment;
import com.example.appointmentsservice.model.QAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, QuerydslPredicateExecutor<Appointment>, QuerydslBinderCustomizer<QAppointment> {
    List<Appointment> findAppointmentByDateAndStatus(LocalDate now, Appointment.Status pending);
}
