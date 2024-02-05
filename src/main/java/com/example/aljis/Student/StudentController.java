package com.example.aljis.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v5/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
    @PutMapping(path = "student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") long id) throws Exception {
        return studentService.update(student, id);
    }
}
