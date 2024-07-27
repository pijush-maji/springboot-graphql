package com.pijush.demographql.query;

import com.pijush.demographql.model.Student;
import com.pijush.demographql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class Query {

    @Autowired
    private StudentService studentService;

    @QueryMapping
    public String firstQuery(){
        return "This is first query from GraphQL";
    }

    @QueryMapping
    public List<Student> getStudent(){
        return studentService.getAllStudent();
    }

    @QueryMapping
    public Student getStudentByName(@Argument String firstName){
        return studentService.getByFirstName(firstName);
    }

    public 
    @MutationMapping
    public Student updateemail(@Argument int id,@Argument String email){
        return studentService.updateEmail(id,email);
    }

    @MutationMapping
    public Student addStudent(@Argument Student student){
        return studentService.addStudent(student);
    }
}
