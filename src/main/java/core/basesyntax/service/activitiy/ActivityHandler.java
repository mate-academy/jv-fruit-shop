package core.basesyntax.service.activitiy;

import core.basesyntax.model.FruitCrate;

public interface ActivityHandler {
    FruitCrate getFruit(String fruitName, int quantity);
}
