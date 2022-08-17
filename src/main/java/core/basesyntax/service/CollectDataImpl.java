package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public class CollectDataImpl implements CollectData {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public FruitTransaction collect(String date) {
        String[] dataArray = date.split(SEPARATOR);
        String operation = dataArray[OPERATION_INDEX];
        String fruit = dataArray[FRUIT_INDEX];
        String amount = dataArray[AMOUNT_INDEX];
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fruit);
        fruitTransaction.setQuantity(Integer.parseInt(amount));
        return fruitTransaction;
    }
}
