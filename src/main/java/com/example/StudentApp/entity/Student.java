package com.example.StudentApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private  int id;

    private String studentId;
    private String name;
    private String email;
    private String phNo;
    private String qualification;
    private String experience;
    @ElementCollection
    private List<String> course;
    private String address;
    private String comment;

}
