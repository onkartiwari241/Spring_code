package com.lcwd.DataJPA.practiceDataJPA.service;

import com.lcwd.DataJPA.practiceDataJPA.models.StudentEntity;
import com.lcwd.DataJPA.practiceDataJPA.repo.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Imple_StudentService implements StudentService{

    Logger logger = LoggerFactory.getLogger(Imple_StudentService.class);

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public StudentEntity saveStudent(StudentEntity studentEntity) {
        StudentEntity savedUser = studentRepo.save(studentEntity);

        logger.info("Id {}",studentEntity.getId());
        logger.info("Name {}",studentEntity.getName());
        logger.info("Address {}",studentEntity.getAddress());
        logger.info("Company {}",studentEntity.getCompany());

        return savedUser;
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity, int id) {

        StudentEntity oldStudent = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Given id data not avilable...."));

        oldStudent.setName(studentEntity.getName());
        oldStudent.setAddress(studentEntity.getAddress());
        oldStudent.setCompany(studentEntity.getCompany());

        studentRepo.save(oldStudent);

        return oldStudent;
    }

    @Override
    public StudentEntity getStudent(int id) {

        Optional<StudentEntity> searchById = studentRepo.findById(id);
        StudentEntity studentEntity = searchById.orElseThrow(() -> new RuntimeException("Given id is not present...."));
        return studentEntity;
    }

    @Override
    public List<StudentEntity> getAllStudent() {
        List<StudentEntity> allStudents= (List<StudentEntity>) studentRepo.findAll();
        return allStudents;
    }

    @Override
    public StudentEntity deleteStudent(int id) {

        StudentEntity studentEntity = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Given id user is not avilable...."));

        studentRepo.delete(studentEntity);
        return studentEntity;
    }
}
