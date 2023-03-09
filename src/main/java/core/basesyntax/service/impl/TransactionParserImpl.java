package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int HEADER_LINE = 1;
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_PRODUCT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String COLUMN_SEPARATOR = ",";

    @Override
    public List<Transaction> parseTransaction(List<String> strings) {
        return strings.stream()
                .skip(HEADER_LINE)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private Transaction parseTransaction(String string) {
        String[] transaction = string.split(COLUMN_SEPARATOR);
        return new FruitTransaction(
                getOperationType(transaction[INDEX_OPERATION_TYPE]),
                transaction[INDEX_PRODUCT_NAME],
                Integer.parseInt(transaction[INDEX_QUANTITY]));
    }

    private FruitTransaction.Operation getOperationType(String code) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(operation -> operation.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The list with transactions "
                        + "contains invalid operation type code '" + code + '\''));
    }
}
