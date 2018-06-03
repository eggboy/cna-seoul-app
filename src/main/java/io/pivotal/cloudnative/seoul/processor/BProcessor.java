package io.pivotal.cloudnative.seoul.processor;

import io.pivotal.cloudnative.seoul.domain.Food;

public class BProcessor implements FoodProcessor{
    @Override
    public Food process(Food food) {
        return food.toBuilder().name("BProcessor: " + food.getName()).build();
    }
}
