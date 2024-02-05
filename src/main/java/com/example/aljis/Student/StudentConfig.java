package com.example.aljis.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            List<Student> list = Arrays.asList(new Student("Mariyam", "mariam.jamal@gmail.com", LocalDate.of(2000, Month.JANUARY, 5)),
                    new Student("Adil", "Adil@gmail.com", LocalDate.of(2030, Month.JANUARY, 5)),
                    new Student("Wagri", "wagri@gmail.com", LocalDate.of(1999, Month.MAY, 29)),
                    new Student("Wagro", "wagro@gmail.com", LocalDate.of(1998, Month.SEPTEMBER, 4)));

            repository.saveAll(list);
        };
    }
}
