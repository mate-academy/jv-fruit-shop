package core.basesyntax.service.impl;

import core.basesyntax.service.DataTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class DataTransactionParserImpl implements DataTransactionParser {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseDataTransaction(String data) {
        String[] dataToArray = data.split(System.lineSeparator());
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String lineInArr : dataToArray) {
            String[] arrWithOperatorAndFruitQuantity = lineInArr.split(COMMA);
            String operation = arrWithOperatorAndFruitQuantity[OPERATION_INDEX];
            String fruitName = arrWithOperatorAndFruitQuantity[FRUIT_NAME_INDEX];
            String quantity = arrWithOperatorAndFruitQuantity[QUANTITY_INDEX];
            FruitTransaction fruitTransaction = new FruitTransaction(
                    operation, Integer.parseInt(quantity), fruitName);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
