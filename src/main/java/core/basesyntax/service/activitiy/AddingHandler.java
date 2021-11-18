package core.basesyntax.service.activitiy;

import core.basesyntax.model.FruitCrate;

public class AddingHandler implements ActivityHandler {
    @Override
    public FruitCrate getFruitCrate(String fruitName, int quantity) {
        return new FruitCrate(fruitName, quantity);
    }
}
