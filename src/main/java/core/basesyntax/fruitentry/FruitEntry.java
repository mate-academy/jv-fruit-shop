package core.basesyntax.fruitentry;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FruitEntry {
    private String fruitName;
    private int quantity;

    public FruitEntry(String fruitName) {
        this(fruitName, 0);
    }
}
