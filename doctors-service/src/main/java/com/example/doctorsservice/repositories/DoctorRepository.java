package com.example.doctorsservice.repositories;

import com.example.doctorsservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findDoctorByIsAvailable(Boolean isAvailable);
}
