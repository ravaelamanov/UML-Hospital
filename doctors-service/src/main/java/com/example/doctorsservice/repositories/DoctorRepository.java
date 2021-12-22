package com.example.doctorsservice.repositories;

import com.example.doctorsservice.model.Doctor;
import com.example.doctorsservice.model.QDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>, QuerydslPredicateExecutor<Doctor>, QuerydslBinderCustomizer<QDoctor> {
    @Override
    default void customize(QuerydslBindings bindings, QDoctor root) {
        bindings.bind(root.schedule.workingDays.any().day).as("dayOfWeek").withDefaultBinding();
/*        bindings.bind(root.schedule.workingDays.any().start).as("startBefore").first(((path, value) -> {path.before(value).and()}));
        bindings.bind(root.schedule.workingDays.any().finish).as("finishAfter").first((TemporalExpression::after));*/
    }
}
