package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface DataParser {
    int ACTIVITY_INDEX = 0;
    int FRUIT_INDEX = 1;
    int NUMBER_INDEX = 2;

    static FruitTransaction getData(String data) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] info = data.split(",");
        fruitTransaction.setOperation(FruitTransaction
                .Operation.determineOperation(info[ACTIVITY_INDEX]));
        fruitTransaction.setFruit(info[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(info[NUMBER_INDEX]));
        return fruitTransaction;
    }
}
