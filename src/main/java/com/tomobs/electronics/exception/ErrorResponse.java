package com.tomobs.electronics.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private String errorCode;
    private Instant timestamp;
}
