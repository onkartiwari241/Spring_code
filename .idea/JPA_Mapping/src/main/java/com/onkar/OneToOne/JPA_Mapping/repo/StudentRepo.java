package com.onkar.OneToOne.JPA_Mapping.repo;

import com.onkar.OneToOne.JPA_Mapping.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
}
