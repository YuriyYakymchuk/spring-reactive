package com.conscensia.reactive.controller;

import com.conscensia.reactive.subscriber.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/subscription")
public class UserSubscriberController {

    private final SimpleSubscriber simpleSubscriber;

    private final ErrorSubscriber errorSubscriber;

    private final BufferableSubscriber bufferableSubscriber;

    private final CacheableSubscriber cacheableSubscriber;

    private final MergeSubscriber mergeSubscriber;

    private final ZipSubscriber zipSubscriber;

    private final ComplexSubscriber complexSubscriber;

    @Autowired
    public UserSubscriberController(SimpleSubscriber simpleSubscriber, BufferableSubscriber bufferableSubscriber, CacheableSubscriber cacheableSubscriber,
                                    ErrorSubscriber errorSubscriber, MergeSubscriber mergeSubscriber, ZipSubscriber zipSubscriber, ComplexSubscriber complexSubscriber) {
        this.simpleSubscriber = simpleSubscriber;
        this.errorSubscriber = errorSubscriber;
        this.bufferableSubscriber = bufferableSubscriber;
        this.cacheableSubscriber = cacheableSubscriber;
        this.mergeSubscriber = mergeSubscriber;
        this.zipSubscriber = zipSubscriber;
        this.complexSubscriber = complexSubscriber;
    }

    @PostMapping("/simple")
    public ResponseEntity<String> createSimpleSubscription() {
        simpleSubscriber.subscribe();
        return new ResponseEntity<>("Simple subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/error")
    public ResponseEntity<String> createErrorSubscription() {
        errorSubscriber.subscribe();
        return new ResponseEntity<>("Error subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/buffer")
    public ResponseEntity<String> createBufferableSubscription() {
        bufferableSubscriber.subscribe();
        return new ResponseEntity<>("Bufferable subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/cache")
    public ResponseEntity<String> createCachableSubscription() {
        cacheableSubscriber.subscribe();
        return new ResponseEntity<>("Cachable subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/merge")
    public ResponseEntity<String> createMergeSubscription() {
        mergeSubscriber.subscribe();
        return new ResponseEntity<>("Merge subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/zip")
    public ResponseEntity<String> createZipSubscription() {
        zipSubscriber.subscribe();
        return new ResponseEntity<>("Zip subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/complex")
    public ResponseEntity<String> createComplexSubscription() {
        complexSubscriber.subscribe();
        return new ResponseEntity<>("Complex subscription has been created.", HttpStatus.CREATED);
    }

}
