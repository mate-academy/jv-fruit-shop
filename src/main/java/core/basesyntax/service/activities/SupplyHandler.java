package core.basesyntax.service.activities;

import core.basesyntax.model.Fruit;

public class SupplyHandler implements Handler {
    private static final int SECOND_CELL_NUMBER = 1;
    private static final int LAST_CELL_NUMBER = 2;

    @Override
    public Fruit createFruitObject(String[] splitLine) {
        Fruit fruit = new Fruit();
        fruit.setFruitName(splitLine[SECOND_CELL_NUMBER]);
        fruit.setFruitQuantity(Integer.parseInt(splitLine[LAST_CELL_NUMBER]));
        return fruit;
    }
}
