package com.onkar.OneToOne.JPA_Mapping.repo;

import com.onkar.OneToOne.JPA_Mapping.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity,String> {
}
