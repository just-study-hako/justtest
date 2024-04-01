package com.example.justtest.requesttest;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateService {
  private final CreateRepository createRepository;
  private final CreateRepository2 createRepository2;

  public void createTest(CreateTestRequestDto createTestRequestDto) {
    CreateEntity create = new CreateEntity(createTestRequestDto);
    create.updateRandom( (int) (Math.random() * 100));
    createRepository.save(create);
  }

  public void createTest2(CreateTestRequestDto createTestRequestDto) {
    CreateEntity2 create = new CreateEntity2(createTestRequestDto);
    createRepository2.save(create);
  }

}
