package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface CreateFruit {
    Fruit createFruit(String fruitName, String amount);
}
