package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int SKIP_TITLE_INDEX = 1;
    private static final String COLUMN_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(String transactions) {
        String[] transactionsArray = transactions.split(System.lineSeparator());
        return Arrays.stream(transactionsArray, SKIP_TITLE_INDEX, transactionsArray.length)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseTransaction(String transaction) {
        String[] transactionColumns = transaction.split(COLUMN_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction
                .setOperation(FruitTransaction.Operation.parse(transactionColumns[TYPE_INDEX]));
        fruitTransaction.setFruit(transactionColumns[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(transactionColumns[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
