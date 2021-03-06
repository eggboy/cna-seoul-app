package io.pivotal.cloudnative.seoul.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder=true)
@Getter
@Entity
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Food implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer price;
    private Integer spicylevel;
}
