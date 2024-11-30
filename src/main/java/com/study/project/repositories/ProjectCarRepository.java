package com.study.project.repositories;

import com.study.project.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectCarRepository extends JpaRepository<Car, Long> {
}
