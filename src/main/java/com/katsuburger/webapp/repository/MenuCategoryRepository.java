package com.katsuburger.webapp.repository;

import com.katsuburger.webapp.domain.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Integer> {

}
