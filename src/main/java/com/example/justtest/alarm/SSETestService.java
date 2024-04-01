package com.example.justtest.alarm;

import jakarta.transaction.Transactional;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@RequiredArgsConstructor
@Transactional
public class SSETestService {

  private final EmitterRepository emitterRepository;
  private static final Long DEFAULT_TIMEOUT = 600L * 1000 * 60;

  public SseEmitter subscribe(Long id) {
    SseEmitter emitter = createEmitter(id);
    sendToClient(id, "EventStream Created. [userId="+ id + "]");
    return emitter;
  }
  private SseEmitter createEmitter(Long userId) {
    SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
    emitterRepository.save(userId, emitter);

    emitter.onCompletion(() -> emitterRepository.deleteById(userId));
    emitter.onTimeout(() -> emitterRepository.deleteById(userId));

    return emitter;
  }
  private void sendToClient(Long userId, Object data) {
    SseEmitter emitter = emitterRepository.get(userId);
    if (emitter != null) {
      try {
        emitter.send(SseEmitter.event()
            .id(String.valueOf(userId))
            .name("sse")
            .data(data)
            .comment("sse 접속 성공"));
      } catch (IOException e) {
        emitterRepository.deleteById(userId);
        emitter.completeWithError(e);
      }
    }

  }
  public void count(Long Userid, SSERequestDto sseRequestDto) {
    String message = sseRequestDto.getDescription();
    SseEmitter emitter = emitterRepository.get(Userid);
    try {
    emitter.send(SseEmitter.event()
        .name("이름")
        .data(message));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
