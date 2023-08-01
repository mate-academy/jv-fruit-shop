package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionMapper;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TransactionMapperImpl implements TransactionMapper {
    private static final String COLUMN_SPLIT_REGEX = ",";
    private static final int TYPE_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;

    @Override
    public List<Transaction> mapAll(List<String> source) {
        return source.stream().skip(1).map(this::mapToTransaction).collect(Collectors.toList());
    }

    private Transaction mapToTransaction(String line) {
        String[] record = line.split(COLUMN_SPLIT_REGEX);
        Transaction.Operation operation = getOperationByCode(record[TYPE_COLUMN]);
        Fruit fruit = new Fruit(record[FRUIT_COLUMN]);
        int quantity = Integer.parseInt(record[QUANTITY_COLUMN]);
        return new Transaction(operation, fruit, quantity);
    }

    private Transaction.Operation getOperationByCode(String code) {
        return Arrays.stream(Transaction.Operation.values())
                .filter(operation -> operation.getCode().equals(code))
                .findAny().orElseThrow(() -> new NoSuchElementException(
                        "No such operation was found. Operation code: " + code));
    }
}
