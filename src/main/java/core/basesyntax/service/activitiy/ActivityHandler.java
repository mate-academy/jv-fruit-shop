package core.basesyntax.service.activitiy;

import core.basesyntax.model.FruitCrate;

public interface ActivityHandler {
    FruitCrate getFruitCrate(String fruitName, int quantity);
}
