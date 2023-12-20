package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseOperationService;
import java.util.ArrayList;
import java.util.List;

public abstract class ParseOperationServiceImpl implements ParseOperationService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int POINT_TO_START_READING = 1;

    @Override
    public List<FruitTransaction> parseContentForOperations(List<String> inputData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String record : inputData) {
            transactions.add(parseTransactions(record));
        }
        return transactions;
    }

    private FruitTransaction parseTransactions(String record) {
        return null;
    }

    private FruitTransaction parseInputData(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] separatedLine = line.split(SEPARATOR);
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperationByCode(separatedLine[OPERATION_INDEX]));
        fruitTransaction.setFruit(separatedLine[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(separatedLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
