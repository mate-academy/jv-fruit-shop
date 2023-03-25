package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserTransactionsService;

public class ParserTransactionsServiceImpl implements ParserTransactionsService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";

    @Override
    public FruitTransaction getDataFromLine(String line) {
        String[] arrayParameters = line.split(SPLIT_SYMBOL);
        FruitTransaction.Operation[] operations = FruitTransaction.Operation.values();
        FruitTransaction fruitTransaction = new FruitTransaction();
        for (int i = 0; i < operations.length;) {
            if (operations[i].getValue().equals(arrayParameters[TYPE_INDEX])) {
                fruitTransaction.setOperation(operations[i]);
                i = operations.length;
            }
            i++;
        }
        fruitTransaction.setFruit(new Fruit(arrayParameters[FRUIT_INDEX]));
        fruitTransaction.setQuantity(Integer.parseInt(arrayParameters[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
