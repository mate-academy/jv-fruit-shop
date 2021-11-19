package core.basesyntax.service.activitiy;

import core.basesyntax.model.FruitCrate;

public interface ActivityHandler {
    FruitCrate updateFruitCrate(String fruitName, int quantity);
}
