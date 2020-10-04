package com.katsuburger.webapp.repository;

import com.katsuburger.webapp.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, String> {
}
