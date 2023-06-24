package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int HEADER_LINE = 1;
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_PRODUCT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String COLUMN_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> stringTransactionsList) {
        return stringTransactionsList.stream()
                .skip(HEADER_LINE)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseTransaction(String stringTransaction) {
        String[] transaction = stringTransaction.split(COLUMN_SEPARATOR);
        return new FruitTransaction(
                FruitTransaction.Operation.getByCode(transaction[INDEX_OPERATION_TYPE]),
                transaction[INDEX_PRODUCT_NAME],
                Integer.parseInt(transaction[INDEX_QUANTITY]));
    }
}
