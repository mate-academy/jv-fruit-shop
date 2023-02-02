package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    static final int INDEX_OPERATION = 0;
    static final int INDEX_FRUIT = 1;
    static final int INDEX_QUANTITY = 2;
    static final int MAX_COLUMN = 3;

    @Override
    public List<FruitTransaction> parseInputDate(List<String> listOfOperations) {
        List<FruitTransaction> result = new ArrayList<>();
        String[] splitString;
        for (int i = 1; i < listOfOperations.size(); i++) {
            splitString = listOfOperations.get(i).split(",");
            if (splitString.length > MAX_COLUMN) {
                throw new RuntimeException("incorrectly entered data");
            }
            result.add(new FruitTransaction(getByCode(splitString[INDEX_OPERATION]),
                    splitString[INDEX_FRUIT],Integer.parseInt(splitString[INDEX_QUANTITY])));
        }
        return result;
    }

    private FruitTransaction.Operation getByCode(String indexOfOperation) {
        for (FruitTransaction.Operation operation: FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(indexOfOperation)) {
                return operation;
            }
        }
        throw new RuntimeException("Wrong operation type");
    }
}
