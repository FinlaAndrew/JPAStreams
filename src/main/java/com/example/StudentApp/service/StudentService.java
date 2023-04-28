package com.example.StudentApp.service;

import com.example.StudentApp.entity.Student;
import com.example.StudentApp.entity.Student$;
import com.example.StudentApp.repository.StudentRepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.example.StudentApp.entity.Student$.*;

@Service
public class StudentService {
@Autowired
public StudentRepo repo;
@Autowired
private JPAStreamer jpaStreamer;
//    public List<Student> saveStudent(List<Student> students) {
//        return repo.saveAll(students);
//    }


   // public List<Student> getStudentByCourse(String course) {
    //    return jpaStreamer.stream(Student.class)
    //            .filter(Student$.course.equal(course))
    //            .collect(Collectors.toList());
    //}
//   public List<Student> getStudentByCourses(List<String> courses) {
//       return jpaStreamer.stream(Student.class)
//               .filter(Student$.course.in(courses))
//               .collect(Collectors.toList());
//   }
    public Long getStudentByCourse(String courses) {
        Predicate<Student> courseFilter = student -> student.getCourse().contains(courses);
        return jpaStreamer.stream(Student.class)
                .filter(courseFilter)
                .count();
    }



    public List<Student> getStudentByAddress(String address) {
        return jpaStreamer.stream(Student.class)
                .filter(Student$.address.equal(address))
                .collect(Collectors.toList());
    }

    public Student add(Student student) {
        return repo.save(student);
    }
}
