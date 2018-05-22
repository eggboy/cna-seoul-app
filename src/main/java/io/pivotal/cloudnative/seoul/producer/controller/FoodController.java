package io.pivotal.cloudnative.seoul.producer.controller;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.pivotal.cloudnative.seoul.producer.domain.Food;
import io.pivotal.cloudnative.seoul.producer.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FoodController {

    SimpleMeterRegistry meterRegistry;

    public FoodController(SimpleMeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Autowired
    FoodRepository foodRepository;

    @GetMapping("/kill")
    public void suicide() {
        log.debug("I killed myself. :(");
        System.exit(99);
    }

    @GetMapping("/food/{id}")
    public Food getCar(@PathVariable String id) {
        log.debug("Getting Car id : " + id);
        meterRegistry.counter("food.service.getCar.invoke").increment();

        return foodRepository.getOne(id);
    }
}
