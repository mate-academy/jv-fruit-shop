package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String LINES_DELIMITER = " ";
    private static final String FIELDS_DELIMITER = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseFruitTransactions(String dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] lines = dataFromFile.split(LINES_DELIMITER);
        for (String line : lines) {
            String[] fieldsOfStrings = line.split(FIELDS_DELIMITER);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationByCode(fieldsOfStrings[INDEX_OF_OPERATION]));
            fruitTransaction.setFruit(fieldsOfStrings[INDEX_OF_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(fieldsOfStrings[INDEX_OF_QUANTITY]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
