package com.hong.tms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hong.tms.common.ApiResponse;
import com.hong.tms.dto.StockDTO;
import com.hong.tms.service.StockService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StockController {

 private final StockService stockService;

 // 전체 조회
 @GetMapping("/getStocks")
 public ResponseEntity<ApiResponse<List<StockDTO>>> getStocks() {
  List<StockDTO> list = stockService.getStocks();
  return ResponseEntity.ok(ApiResponse.success(list));
 }

 // 등록
 @PostMapping("/registStock")
 public ResponseEntity<ApiResponse<StockDTO>> registStock(@RequestBody StockDTO dto) {
  StockDTO res = stockService.registerStock(dto);
  return ResponseEntity.ok(ApiResponse.success(res));
 }

 // 수정
 @PostMapping("/modifyStock")
 public ResponseEntity<ApiResponse<StockDTO>> modifyStock(@RequestBody StockDTO dto) {
  StockDTO res = stockService.modifyStock(dto);
  return ResponseEntity.ok(ApiResponse.success(res));
 }

 // 삭제
 @PostMapping("/deleteStock")
 public ResponseEntity<ApiResponse<Boolean>> deleteStock(@RequestBody StockDTO dto) {
  Boolean isDeleted = stockService.deleteStock(dto.getSno());
  return ResponseEntity.ok(ApiResponse.success(isDeleted));
 }

}
