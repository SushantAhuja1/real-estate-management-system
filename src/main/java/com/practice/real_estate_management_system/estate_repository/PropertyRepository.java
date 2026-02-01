package com.practice.real_estate_management_system.estate_repository;

import com.practice.real_estate_management_system.estate_entity.Property;
import com.practice.real_estate_management_system.estate_entity.PropertyStatus;
import com.practice.real_estate_management_system.estate_entity.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long>  {
    public List<Property> findByOwner(String owner);
    public List<Property> findByStatus(PropertyStatus status);
    public List<Property> findByType(PropertyType type);

}
