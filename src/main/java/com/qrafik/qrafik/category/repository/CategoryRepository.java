package com.qrafik.qrafik.category.repository;

import com.qrafik.qrafik.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByWorkplace_Id(Long workplaceId);
}
