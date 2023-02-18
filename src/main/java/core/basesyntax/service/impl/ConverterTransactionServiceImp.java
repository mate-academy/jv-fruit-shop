package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConverterService;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterTransactionServiceImp implements ConverterService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> convertFromStringToFunction(List<String> transactions) {
        return transactions.stream()
                .map(s -> s.split(","))
                .map(t -> {
                    String operation = t[OPERATION_INDEX];
                    String fruit = t[FRUIT_NAME_INDEX];
                    int quantity = Integer.parseInt(t[QUANTITY_INDEX]);
                    return new Transaction(operation, fruit, quantity);
                }).collect(Collectors.toList());
    }
}
