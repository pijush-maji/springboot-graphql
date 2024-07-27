package com.pijush.demographql.service;

import com.pijush.demographql.model.Student;
import com.pijush.demographql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getByFirstName(String firstName){
        System.out.println(firstName);
        return studentRepository.getByFirstName(firstName);
    }

    public Student updateEmail(int id,String email){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student does not exist!")
        );
        student.setEmail(email);
        return studentRepository.save(student);

    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
}
