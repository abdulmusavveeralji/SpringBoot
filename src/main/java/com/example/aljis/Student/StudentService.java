package com.example.aljis.Student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student save(Student student) {
        Optional<Student> studentByEmail = repository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }
        return repository.save(student);
    }
    public Student update(Student student, long id) throws Exception {
        Optional<Student> hasStudent = repository.findById(id);
        if(hasStudent.isEmpty())
            throw new IllegalAccessException("Record not found");
        return repository.save(student);
    }
}
