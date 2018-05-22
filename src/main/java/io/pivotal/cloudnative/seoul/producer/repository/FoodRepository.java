package io.pivotal.cloudnative.seoul.producer.repository;

import io.pivotal.cloudnative.seoul.producer.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FoodRepository extends JpaRepository<Food, String> {
}
