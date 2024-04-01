package com.example.justtest.alarm;


import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/alarm")
@RequiredArgsConstructor
public class AlarmController {

  private final SseEmitters sseEmitters;
  @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public ResponseEntity<SseEmitter> connect() {
    SseEmitter emitter = new SseEmitter();
    sseEmitters.add(emitter);
    try {
      emitter.send(SseEmitter.event()
          .name("connect")  // 해당 이벤트의 이름 지점
          .data("connected!")); // 503 에러 방지를 위한 더미 데이터
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return ResponseEntity.ok(emitter);
  }
  @PostMapping("/count")
  public ResponseEntity<Void> count() {
    sseEmitters.count();
    return ResponseEntity.ok().build();
  }

}
