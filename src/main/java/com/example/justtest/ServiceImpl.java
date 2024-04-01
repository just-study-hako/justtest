package com.example.justtest;

import com.example.justtest.dto.CreateRequestDto;
import com.example.justtest.dto.GetReviewResponseDto;
import com.example.justtest.dto.UpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ServiceImpl implements ServiceS {

  private final Repository repository;

  // 리뷰 생성
  @Override
  public void createReview(CreateRequestDto createRequestDto) {
    System.out.println("2222");
    EntityR entity = new EntityR(createRequestDto);
    System.out.println("3333");
    repository.save(entity);
  }

  // 리뷰 수정
  @Override
  public void updateReview(UpdateRequestDto updateRequestDto) {
    EntityR entity = repository.findById(updateRequestDto.getReviewId())
        .orElseThrow(() -> new NullPointerException("수정할 리뷰가 없습니다."));
    entity.updateReview(updateRequestDto);
  }

  // 리뷰 단일 조회
  @Override
  public GetReviewResponseDto getReview(Long reviewId) {
    EntityR review = findReview(reviewId);
    return new GetReviewResponseDto(review);
  }

  public EntityR findReview(Long reviewId) {
    return repository.findById(reviewId)
        .orElseThrow(() -> new NullPointerException("리뷰가 존재하지 않습니다."));
  }


  @Override
  public void deleteReview(Long reviewId) {
    EntityR review = findReview(reviewId);
    repository.delete(review);
  }
}
