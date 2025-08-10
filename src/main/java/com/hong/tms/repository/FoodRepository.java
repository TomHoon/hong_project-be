package com.hong.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hong.tms.entity.FoodEntity;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

}
