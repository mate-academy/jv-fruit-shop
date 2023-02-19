package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConverterService;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterTransactionServiceImp implements ConverterService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> convertFromString(List<String> transactions) {
        return transactions.stream()
                .map(s -> s.split(","))
                .map(this::parseToTransaction).collect(Collectors.toList());
    }

    private Transaction parseToTransaction(String[] line) {
        String operation = line[OPERATION_INDEX];
        String fruit = line[FRUIT_NAME_INDEX];
        int quantity = Integer.parseInt(line[QUANTITY_INDEX]);
        return new Transaction(Operation.getByCode(operation), fruit, quantity);
    }
}
