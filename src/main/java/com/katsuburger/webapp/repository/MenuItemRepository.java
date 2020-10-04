package com.katsuburger.webapp.repository;

import com.katsuburger.webapp.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, String> {
}
