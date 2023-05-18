package com.lcwd.DataJPA.practiceDataJPA.service;

import com.lcwd.DataJPA.practiceDataJPA.models.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity saveStudent(StudentEntity studentEntity);
    StudentEntity updateStudent(StudentEntity studentEntity,int id);

    StudentEntity getStudent(int id);

    List<StudentEntity> getAllStudent();

    StudentEntity deleteStudent(int id);
}
