package com.example.cardsservice.repositories;

import com.example.cardsservice.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {

    @Query("SELECT m.doctorId " +
            "FROM MedicalCard m " +
            "WHERE m.doctorId IN :doctor_ids " +
            "GROUP BY m.doctorId " +
            "ORDER BY COUNT(m.doctorId) ASC")
    Optional<Long> getDoctorWithLowestPatientCount(@Param("doctor_ids") List<Long> doctorIds);

    @Query("SELECT COUNT(m.doctorId) FROM MedicalCard m WHERE m.doctorId = :doctor_id")
    Long getDoctorPatientCount(@Param("doctor_id") Long doctorId);
}
