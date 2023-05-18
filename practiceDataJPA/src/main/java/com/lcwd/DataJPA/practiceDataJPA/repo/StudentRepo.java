package com.lcwd.DataJPA.practiceDataJPA.repo;

import com.lcwd.DataJPA.practiceDataJPA.models.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.Id;


public interface StudentRepo extends CrudRepository<StudentEntity,Integer> {

}
