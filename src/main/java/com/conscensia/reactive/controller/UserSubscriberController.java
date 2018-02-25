package com.conscensia.reactive.controller;

import com.conscensia.reactive.subscriber.*;
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

    private final CachableSubscriber cachableSubscriber;

    private final ZipSubscriber zipSubscriber;

    private final MergeSubscriber mergeSubscriber;

    private final BackPressureSubscriber backPressureSubscriber;

    @Autowired
    public UserSubscriberController(SimpleSubscriber simpleSubscriber, BufferableSubscriber bufferableSubscriber, CachableSubscriber cachableSubscriber,
                                    ZipSubscriber zipSubscriber, ErrorSubscriber errorSubscriber, MergeSubscriber mergeSubscriber, BackPressureSubscriber backPressureSubscriber) {
        this.simpleSubscriber = simpleSubscriber;
        this.errorSubscriber = errorSubscriber;
        this.bufferableSubscriber = bufferableSubscriber;
        this.cachableSubscriber = cachableSubscriber;
        this.zipSubscriber = zipSubscriber;
        this.mergeSubscriber = mergeSubscriber;
        this.backPressureSubscriber = backPressureSubscriber;
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
        cachableSubscriber.subscribe();
        return new ResponseEntity<>("Cachable subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/zip")
    public ResponseEntity<String> createZipSubscription() {
        zipSubscriber.subscribe();
        return new ResponseEntity<>("Zip subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/merge")
    public ResponseEntity<String> createMergeSubscription() {
        mergeSubscriber.subscribe();
        return new ResponseEntity<>("Merge subscription has been created.", HttpStatus.CREATED);
    }

    @PostMapping("/backpressure")
    public ResponseEntity<String> createBackPressureSubscription() {
        backPressureSubscriber.subscribe();
        return new ResponseEntity<>("BackPressure subscription has been created.", HttpStatus.CREATED);
    }

}
