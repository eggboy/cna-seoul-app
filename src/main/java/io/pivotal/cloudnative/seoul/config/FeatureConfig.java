package io.pivotal.cloudnative.seoul.config;

import io.pivotal.cloudnative.seoul.processor.FoodProcessor;
import io.pivotal.cloudnative.seoul.processor.AProcessor;
import io.pivotal.cloudnative.seoul.processor.BProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureConfig {
    @Bean
    @RefreshScope
    @Value("${feature.food.process.new}")
    public FoodProcessor foodProcessor(String flag) {
        if("false".equals(flag))
            return new AProcessor();
        else
            return new BProcessor();
    }
}
