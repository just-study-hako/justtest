package com.example.justtest.reviewcrud;

import com.example.justtest.reviewcrud.dto.CreateRequestDto;
import com.example.justtest.reviewcrud.dto.GetReviewResponseDto;
import com.example.justtest.reviewcrud.dto.UpdateRequestDto;

public interface ServiceS {

  void createReview(CreateRequestDto createRequestDto);

  void updateReview(UpdateRequestDto updateRequestDto);

  GetReviewResponseDto getReview(Long reviewId);


  void deleteReview(Long reviewId);

}