package com.katsuburger.webapp.repository;

import com.katsuburger.webapp.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
