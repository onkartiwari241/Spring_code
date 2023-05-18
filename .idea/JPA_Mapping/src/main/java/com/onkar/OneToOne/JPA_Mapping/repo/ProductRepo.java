package com.onkar.OneToOne.JPA_Mapping.repo;

import com.onkar.OneToOne.JPA_Mapping.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity,String> {
}
