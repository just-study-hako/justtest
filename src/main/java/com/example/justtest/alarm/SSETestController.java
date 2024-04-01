package com.example.justtest.alarm;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/ssetest")
@RequiredArgsConstructor
public class SSETestController {
  private  final SSETestService sseTestService;


  @GetMapping(path="/{id}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribe(@PathVariable Long id){
    return sseTestService.subscribe(id);
  }

  @PostMapping("/{id}")
  public ResponseEntity<Void> count(@PathVariable Long id,@RequestBody SSERequestDto sseRequestDto) {
    System.out.println(sseRequestDto.getDescription());
    sseTestService.count(id, sseRequestDto);

    return ResponseEntity.ok().build();
  }

}
