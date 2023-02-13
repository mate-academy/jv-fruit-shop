package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> getTransactions(List<String> csvStrings) {
        return csvStrings.stream()
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseTransaction(String csvLine) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = csvLine.split(",");
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperation(fields[INDEX_OF_OPERATION]));
        fruitTransaction.setFruit(fields[INDEX_OF_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_OF_QUANTITY]));
        return fruitTransaction;
    }
}
