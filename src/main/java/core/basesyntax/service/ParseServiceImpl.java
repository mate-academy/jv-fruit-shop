package core.basesyntax.service;

import core.basesyntax.template.FruitTransaction;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_TYPE = 2;

    @Override
    public FruitTransaction parseLine(String operation) {
        String[] fields = operation.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction
                .Operation.getByCode(fields[OPERATION_TYPE_INDEX]));
        fruitTransaction.setFruit(fields[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[FRUIT_QUANTITY_TYPE]));
        return fruitTransaction;
    }
}
