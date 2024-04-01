package com.example.justtest.requesttest;

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
public class CreateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "review_id", nullable = false)
  private Long id;
  @Column(name = "shop_id", nullable = false)
  private Long shopId;
  @Column(name = "description", nullable = false)
  private Integer random;


  public CreateEntity(CreateTestRequestDto createTestRequestDto) {
    this.shopId = createTestRequestDto.getShopId();
  }

  public void updateRandom(Integer num) {
    this.random = num;
  }
}
