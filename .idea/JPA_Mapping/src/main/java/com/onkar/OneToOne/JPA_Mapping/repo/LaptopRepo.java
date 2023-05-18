package com.onkar.OneToOne.JPA_Mapping.repo;

import com.onkar.OneToOne.JPA_Mapping.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<LaptopEntity,Integer> {
}
