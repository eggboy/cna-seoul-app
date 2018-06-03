package io.pivotal.cloudnative.seoul.processor;

import io.pivotal.cloudnative.seoul.domain.Food;
import org.springframework.stereotype.Component;

@Component
public interface FoodProcessor {
    Food process(Food food);
}
