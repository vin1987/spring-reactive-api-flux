package com.reactiveapi.demo.api;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ApiController {
    
    @GetMapping(value = "/count" ,produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getMessage(){
        Random r = new Random();
        int low = 0 ;
        int high = 100 ;

        return Flux.fromStream(Stream.generate(() -> r.nextInt(high-low) +low )
        .map(s -> String.valueOf(s))
        ).delayElements(Duration.ofSeconds(1));
    }
}
