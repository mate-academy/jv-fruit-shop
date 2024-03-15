package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements TransactionParser {
    private static final String SPLIT_DELIMITER = ",";
    private static final int INDEX_FOR_OPERATION = 0;
    private static final int INDEX_FOR_NAME = 1;
    private static final int INDEX_FOR_QUANTITY = 2;

    @Override
    public List<FruitTransaction> converterToTransactions(List<String> readData) {
        List<String[]> collect = readData.stream()
                .skip(1)
                .map(s -> s.split(SPLIT_DELIMITER))
                .toList();

        List<FruitTransaction> transactionList = new ArrayList<>();
        FruitTransaction fruitTransaction;
        for (String[] strings : collect) {
            String fruitName = strings[INDEX_FOR_NAME];
            int quantity = Integer.parseInt(strings[INDEX_FOR_QUANTITY]);
            String operationType = strings[INDEX_FOR_OPERATION]
                    .substring(strings[INDEX_FOR_OPERATION].length() - 1);
            // this is required to ignore the characters before the transaction code
            fruitTransaction =
                    new FruitTransaction(fruitName, quantity, getOperationType(operationType));
            transactionList.add(fruitTransaction);
            if (quantity < 0) {
                throw new RuntimeException("Quantity of fruit can not be less zero: "
                        + "\""
                        + quantity
                        + "\"");
            }
        }
        return transactionList;
    }

    private FruitTransaction.Operation getOperationType(String operationType) {
        return FruitTransaction.Operation.fromCode(operationType);
    }
}
