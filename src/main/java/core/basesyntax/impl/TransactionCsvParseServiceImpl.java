package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;

public class TransactionCsvParseServiceImpl implements ParseService<FruitTransaction> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    @Override
    public FruitTransaction parse(String line) {
        String[] separatedLine = line.split(DELIMITER);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(separatedLine[OPERATION_INDEX]);
        fruitTransaction.setFruit(separatedLine[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(separatedLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
