package core.basesyntax.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Fruit {
    private String fruit;
    private int quantity;
}
