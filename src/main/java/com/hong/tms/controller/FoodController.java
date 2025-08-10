package com.hong.tms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hong.tms.common.ApiResponse;
import com.hong.tms.dto.FoodDTO;
import com.hong.tms.service.FoodService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/food")
public class FoodController {

 private final FoodService foodService;

 @GetMapping("/getFoods")
 public ResponseEntity<ApiResponse<List<FoodDTO>>> getFoods() {

  List<FoodDTO> list = foodService.getFoods();
  return ResponseEntity.ok(ApiResponse.success(list));
  
 }

}
