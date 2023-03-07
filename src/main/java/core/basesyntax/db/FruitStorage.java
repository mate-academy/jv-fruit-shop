package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.CsvFileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitStorage implements Storage {
    private static final int HEADER_LINE = 1;
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_PRODUCT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String COLUMN_SEPARATOR = ",";
    private final CsvFileReader reader;

    public FruitStorage(CsvFileReader reader) {
        this.reader = reader;
    }

    @Override
    public List<Transaction> getTransactions() {
        return reader.read().stream()
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

    private Operation getOperationType(String code) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The source file '" + reader.getFileName()
                        + "' contains invalid operation type code '" + code + '\''));
    }
}
