package com.hong.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hong.tms.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
