package com.practice.real_estate_management_system.estate_repository;

import com.practice.real_estate_management_system.estate_entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
