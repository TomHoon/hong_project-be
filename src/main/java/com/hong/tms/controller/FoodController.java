package com.hong.tms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hong.tms.common.ApiResponse;
import com.hong.tms.dto.FoodDTO;
import com.hong.tms.service.FoodService;
import com.hong.tms.utils.FileUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/food")
public class FoodController {

  private final FoodService foodService;
  private final FileUtil fileUtil;

  @PostMapping("/uploadImage")
  public ResponseEntity<ApiResponse<Map<String, Object>>> uploadImage(@RequestParam("file") MultipartFile file) {
    try {

      String fileURL = fileUtil.upload(file);
      return ResponseEntity.ok(ApiResponse.success(Map.of("이미지경로", fileURL)));

    } catch (IOException e) {

      return ResponseEntity.status(500).body(ApiResponse.error("업로드 실패: " + e.getMessage()));

    }

  }

  @GetMapping("/getFoods")
  public ResponseEntity<ApiResponse<List<FoodDTO>>> getFoods() {

    List<FoodDTO> list = foodService.getFoods();
    return ResponseEntity.ok(ApiResponse.success(list));

  }

  // 상세조회
  @GetMapping("/getOneFood/{fno}")
  public ResponseEntity<ApiResponse<FoodDTO>> getOneFood(@PathVariable Long fno) {
    FoodDTO dto = foodService.getOneFood(fno);
    return ResponseEntity.ok(ApiResponse.success(dto));
  }

  // 수정
  @PutMapping("/updateFood")
  public ResponseEntity<ApiResponse<FoodDTO>> updateFood(@RequestBody FoodDTO dto) {
    FoodDTO resDTO = foodService.updateFood(dto);
    return ResponseEntity.ok(ApiResponse.success(resDTO));
  }

  // 등록
  @PostMapping("/registerFood")
  public ResponseEntity<ApiResponse<FoodDTO>> registerFood(@RequestBody FoodDTO dto) {
    FoodDTO resDTO = foodService.registerFood(dto);
    return ResponseEntity.ok(ApiResponse.success(resDTO));
  }

  // 삭제
  @DeleteMapping("/deleteFood/{fno}")
  public ResponseEntity<ApiResponse<Map<String, Object>>> deleteFood(@PathVariable Long fno) {
    FoodDTO dto = foodService.deleteFood(fno);
    Map<String, Object> map = new HashMap<>();
    map.put("결과", true);
    map.put("삭제대상", dto);

    return ResponseEntity.ok(ApiResponse.success(map));
  }

}
