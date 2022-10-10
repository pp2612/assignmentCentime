package com.centimeassignment.first.service.respository;

import com.centimeassignment.first.service.entity.DetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<DetailsEntity, Integer> {
}
