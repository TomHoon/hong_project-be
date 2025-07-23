package com.hong.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hong.tms.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

}
