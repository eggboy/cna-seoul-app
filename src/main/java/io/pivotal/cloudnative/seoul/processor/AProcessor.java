package io.pivotal.cloudnative.seoul.processor;

import io.pivotal.cloudnative.seoul.domain.Food;

public class AProcessor implements FoodProcessor{
    @Override
    public Food process(Food food) {
        return food.toBuilder().name("AProcessor: " + food.getName()).build();
    }
}
