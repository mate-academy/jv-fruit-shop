package core.basesyntax.fruitentry;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FruitEntry {
    private String fruit;
    private int quantity;
}
