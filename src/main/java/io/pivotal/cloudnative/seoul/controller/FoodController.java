package io.pivotal.cloudnative.seoul.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.pivotal.cloudnative.seoul.domain.Food;
import io.pivotal.cloudnative.seoul.processor.FoodProcessor;
import io.pivotal.cloudnative.seoul.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class FoodController {

    FoodProcessor foodProcessor;
    FoodRepository foodRepository;
    MeterRegistry meterRegistry;

    public FoodController(MeterRegistry meterRegistry, FoodProcessor foodProcessor,FoodRepository foodRepository ) {
        this.foodProcessor = foodProcessor;
        this.meterRegistry = meterRegistry;
        this.foodRepository = foodRepository;
    }

    @GetMapping("/food/{id}")
    public Food getFood(@PathVariable String id) {
        log.debug("Getting Food id : " + id);
        meterRegistry.counter("food.service.getCar.invoke").increment();

        return foodProcessor.process(foodRepository.findById(id).orElse(Food.builder().build()));
    }

    @GetMapping("/session")
    public String hello(HttpSession session) {
        String sessionId = (String) session.getAttribute("sessionId");
        log.info("sessionId : " + sessionId);
        if (sessionId == null) {
            sessionId = session.getId();
            session.setAttribute("sessionId", sessionId);
        }

        return "Instance Id :" + System.getenv("INSTANCE_INDEX") + ", SessionId: " + sessionId;
    }
}
