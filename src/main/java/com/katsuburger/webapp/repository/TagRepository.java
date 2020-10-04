package com.katsuburger.webapp.repository;

import com.katsuburger.webapp.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
