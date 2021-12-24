package com.jgonzalezoria.obspringapirestlaptop.repository;

import com.jgonzalezoria.obspringapirestlaptop.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
