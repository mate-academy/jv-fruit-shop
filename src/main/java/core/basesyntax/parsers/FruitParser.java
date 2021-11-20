package core.basesyntax.parsers;

import core.basesyntax.model.Fruits;

public interface FruitParser {
    public Fruits getFruitService(String fruitName, int quantity);
}
