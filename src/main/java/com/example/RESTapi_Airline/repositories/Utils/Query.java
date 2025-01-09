package com.example.RESTapi_Airline.repositories.Utils;

import org.springframework.http.ResponseEntity;

public interface Query<I, O> {
    ResponseEntity<O> execute(I input);
}
