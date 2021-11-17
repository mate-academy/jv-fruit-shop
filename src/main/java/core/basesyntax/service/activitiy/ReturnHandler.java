package core.basesyntax.service.activitiy;

import core.basesyntax.model.FruitCrate;

public class ReturnHandler implements ActivityHandler {
    @Override
    public FruitCrate getFruit(String fruitName, int quantity) {
        return new FruitCrate(fruitName, quantity);
    }
}
