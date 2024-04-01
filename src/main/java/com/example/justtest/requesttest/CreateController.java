package com.example.justtest.requesttest;

import com.example.justtest.dto.CreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/create")
public class CreateController {
  private final CreateService createService;

  @PostMapping
  public void createTest (@RequestBody CreateTestRequestDto createRequestDto){
    System.out.println("그냥 랜덤 메서드 사용한거");
    long beforeTime = System.currentTimeMillis();//코드 실행 전에 시간 받아오기
    System.out.println(beforeTime);
    createService.createTest (createRequestDto);
    long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    System.out.println(afterTime);
    long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
    System.out.println("시간차이(m) : "+secDiffTime);
  }
  @PostMapping("/2")
  public void createTest2 (@RequestBody CreateTestRequestDto createRequestDto){
    System.out.println("랜덤값 바로 넣기");
    long beforeTime = System.currentTimeMillis();//코드 실행 전에 시간 받아오기
    System.out.println(beforeTime);
    createService.createTest2 (createRequestDto);
    long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    System.out.println(afterTime);
    long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
    System.out.println("시간차이(m) : "+secDiffTime);
  }

}
