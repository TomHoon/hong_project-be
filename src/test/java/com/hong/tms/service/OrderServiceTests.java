package com.hong.tms.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hong.tms.dto.OrderDTO;

@SpringBootTest
public class OrderServiceTests {

 @Autowired
 private OrderService orderService;

 @Test
 public void read() {
  List<OrderDTO> list = orderService.getAll();
 }

 @Test
 public void register() {
  OrderDTO dto = new OrderDTO();
  dto.setOrderDate("20250723");
  dto.setOrderName("testname");
  dto.setOrderNo("001");
  dto.setOrderStatus("test");

  OrderDTO res = orderService.registerOrder(dto);

 }
}
