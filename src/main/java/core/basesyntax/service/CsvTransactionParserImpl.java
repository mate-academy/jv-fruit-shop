package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;


public class CsvTransactionParserImpl implements CsvTransactionParser {
    private static final int OPERATION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int QUANTITY = 2;
    private FruitTransaction fruitTransaction;

    public FruitTransaction getFruitTransaction(List<String> operations) {
        for (String record : operations) {
            String[] array = new String[3];
            array = record.split(",");

            fruitTransaction.setOperation(FruitTransaction.Operation.valueOf(array[OPERATION]));
            fruitTransaction.setFruit(array[TYPE_OF_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(array[QUANTITY]));
        }
        return fruitTransaction;
    }


}

