package io.pivotal.cloudnative.seoul.repository;

import io.pivotal.cloudnative.seoul.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FoodRepository extends JpaRepository<Food, String> {
    List<Food> findAllByNameContainsAndAndSpicylevel(String name, Integer spicylevel);
}
