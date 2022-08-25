package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParcerService;
import java.util.List;
import java.util.stream.Collectors;

public class ParcerServiceImpl implements ParcerService {
    private static final String DATA_SEPARATOR = ",";
    private static final int COLUMN_WITH_OPERATION = 0;
    private static final int COLUMN_WITH_NAME = 1;
    private static final int COLUMN_WITH_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        return transactions.stream()
                .skip(1)
                .map(this::getFromStringRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromStringRow(String line) {
        String[] fields = line.split(DATA_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = parseOperation(fields[COLUMN_WITH_OPERATION]);
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruitName(fields[COLUMN_WITH_NAME]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[COLUMN_WITH_QUANTITY]));
        return fruitTransaction;
    }

    private FruitTransaction.Operation parseOperation(String operationMarker) {
        switch (operationMarker) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
            default :
                return FruitTransaction.Operation.RETURN;
        }
    }
}
