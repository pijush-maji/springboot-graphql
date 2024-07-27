package com.pijush.demographql.repository;

import com.pijush.demographql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student getByFirstName(String firstName);
}
