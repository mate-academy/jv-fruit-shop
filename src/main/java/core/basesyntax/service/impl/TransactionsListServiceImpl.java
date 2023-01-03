package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsListService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionsListServiceImpl implements TransactionsListService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String COMMA_DELIMITER = ",";

    @Override
    public List<FruitTransaction> getTransactionsList(String lines, Map<String, Integer> fruitMap) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        String[] splitLines = lines.split(System.lineSeparator());
        for (int i = 1; i < splitLines.length; i++) {
            String[] splittedLine = splitLines[i].trim().split(COMMA_DELIMITER);
            FruitTransaction fruitTransaction = new FruitTransaction.FruitTransactionBuilder()
                    .setOperation(FruitTransaction.Operation
                            .getOperationByLetter(splittedLine[OPERATION_TYPE_INDEX]))
                    .setFruit(splittedLine[FRUIT_TYPE_INDEX])
                    .setQuantity(Integer.parseInt(splittedLine[AMOUNT_INDEX]))
                    .build();
            fruitTransactionsList.add(fruitTransaction);
        }
        return fruitTransactionsList;
    }
}
