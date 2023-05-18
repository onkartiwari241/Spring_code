package com.lbms.libraryManagementSystem.repo;

import com.lbms.libraryManagementSystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,Integer> {
}
