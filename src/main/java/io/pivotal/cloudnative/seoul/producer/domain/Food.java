package io.pivotal.cloudnative.seoul.producer.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@ToString
public class Food {
    @Id
    String name;
    Integer price;
    Integer spicylevel;
    String description;
}
