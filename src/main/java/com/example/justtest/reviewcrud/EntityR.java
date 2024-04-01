package com.example.justtest.reviewcrud;

import com.example.justtest.reviewcrud.dto.CreateRequestDto;
import com.example.justtest.reviewcrud.dto.UpdateRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EntityR {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id", nullable = false)
  private Long id;
  @Column(name = "shop_id", nullable = false)
  private Long shopId;
  @Column(name = "description", nullable = false)
  private String description;

  public EntityR(CreateRequestDto createRequestDto) {
    this.shopId = createRequestDto.getShopId();
    this.description = createRequestDto.getDescription();
  }

  public void updateReview(UpdateRequestDto updateRequestDto) {
    this.description = updateRequestDto.getDescription();
  }

}
