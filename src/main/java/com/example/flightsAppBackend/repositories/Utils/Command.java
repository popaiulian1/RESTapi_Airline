package com.example.flightsAppBackend.repositories.Utils;

import org.springframework.http.ResponseEntity;

public interface Command<I, O> {
    ResponseEntity<O> execute(I input);
}
