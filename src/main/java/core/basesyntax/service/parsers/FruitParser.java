package core.basesyntax.service.parsers;

import core.basesyntax.model.Fruit;

public interface FruitParser {
    Fruit parse(String fruitName);
}
