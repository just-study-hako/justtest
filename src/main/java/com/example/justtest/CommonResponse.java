package com.example.justtest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

  private T data;

  public static <T> ResponseEntity<CommonResponse<T>> ok(T data) {
    return ResponseEntity.ok().body(CommonResponse.<T>builder().data(data).build());
  }
}
