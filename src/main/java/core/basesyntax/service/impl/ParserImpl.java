package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public FruitTransaction parse(String line) {
        String[] splitter = line.split(",");
        FruitTransaction fruit = new FruitTransaction();
        fruit.setOperation(FruitTransaction.Operation.getCode(splitter[OPERATION_INDEX]));
        String fruitOperation = splitter[FRUIT_INDEX];
        fruit.setFruit(fruitOperation);
        fruit.setAmount(Integer.parseInt(splitter[AMOUNT_INDEX]));
        return fruit;
    }
}
