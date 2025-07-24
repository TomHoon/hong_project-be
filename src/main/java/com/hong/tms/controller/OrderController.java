package com.hong.tms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hong.tms.common.ApiResponse;
import com.hong.tms.dto.OrderDTO;
import com.hong.tms.service.OrderService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

 private final OrderService orderService;

 // 전체 조회
 @GetMapping("/getOrders")
 public ResponseEntity<ApiResponse<List<OrderDTO>>> getOrders() {
  List<OrderDTO> list = orderService.getAll();
  return ResponseEntity.ok(ApiResponse.success(list));
 }

 // 등록
 @PostMapping("/registOrder")
 public ResponseEntity<ApiResponse<OrderDTO>> registOrder(@RequestBody OrderDTO dto) {
  OrderDTO res = orderService.registerOrder(dto);
  return ResponseEntity.ok(ApiResponse.success(res));
 }

 // 수정
 @PostMapping("/modifyOrder")
 public ResponseEntity<ApiResponse<OrderDTO>> modifyOrder(@RequestBody OrderDTO dto) {
  OrderDTO res = orderService.modifyOrder(dto);
  return ResponseEntity.ok(ApiResponse.success(res));
 }

 // 삭제
 @PostMapping("/deleteOrder")
 public ResponseEntity<ApiResponse<Boolean>> deleteOrder(@RequestBody OrderDTO dto) {
  Boolean isDeleted = orderService.deleteOrder(dto.getOno());
  return ResponseEntity.ok(ApiResponse.success(isDeleted));
 }

}
