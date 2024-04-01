package com.example.justtest;

import com.example.justtest.dto.CreateRequestDto;
import com.example.justtest.dto.GetReviewResponseDto;
import com.example.justtest.dto.UpdateRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class Controller {
  Service service;

  // 리뷰 생성
  @PostMapping
  public void createReviews(
      @RequestBody CreateRequestDto CreateRequestDto) {
    service.createReview(CreateRequestDto);
  }

  // 리뷰 수정
  @PutMapping
  public void updateReviews(
      @RequestBody UpdateRequestDto UpdateRequestDto) {
    service.updateReview( UpdateRequestDto);
  }

  // 리뷰 삭제
  @DeleteMapping("/{reviewId}")
  public void deleteReview(
      @PathVariable Long reviewId) {
    service.deleteReview(reviewId);
  }

  // 리뷰 조회 단일
  @GetMapping("/{reviewId}")
  public ResponseEntity<CommonResponse<GetReviewResponseDto>> getReview(
      @PathVariable Long reviewId) {
    return CommonResponse.ok(service.getReview(reviewId));
  }

  // 리뷰 조회 전체
  @GetMapping
  public ResponseEntity<CommonResponse<List<GetReviewResponseDto>>> getReviews() {
    return CommonResponse.ok(service.getMyReviews());
  }

  // 상점의 리뷰 조회 전체
  @GetMapping("/{shopId}")
  public ResponseEntity<CommonResponse<List<GetReviewResponseDto>>> getReviews(
      @PathVariable Long shopId) {
    return CommonResponse.ok(service.getShopReviews(shopId));
  }

}
