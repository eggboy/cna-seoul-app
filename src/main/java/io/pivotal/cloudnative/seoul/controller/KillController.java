package io.pivotal.cloudnative.seoul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class KillController {
    @GetMapping("/kill")
    public void suicide() {
        log.debug("I killed myself. :(");
        System.exit(99);
    }

    @GetMapping("/fill-heap")
    public void fillHeap() {
        log.info("Filling heap with junk, to initiate a crash");
        List<int[]> junk = new ArrayList<>();
        while (true) {
            junk.add(new int[9999999]);
        }
    }
}
