package com.example.justtest;

import com.example.justtest.dto.CreateRequestDto;
import com.example.justtest.dto.GetReviewResponseDto;
import com.example.justtest.dto.UpdateRequestDto;

public interface ServiceS {

  void createReview(CreateRequestDto createRequestDto);

  void updateReview(UpdateRequestDto updateRequestDto);

  GetReviewResponseDto getReview(Long reviewId);


  void deleteReview(Long reviewId);

}