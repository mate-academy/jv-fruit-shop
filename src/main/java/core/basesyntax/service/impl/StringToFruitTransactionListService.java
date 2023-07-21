package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StringToListService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToFruitTransactionListService implements StringToListService<FruitTransaction> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(String string) {
        String[] transactions = string.split(System.lineSeparator());
        return Arrays.stream(transactions)
                .map(t -> {
                    String[] transactionInArray = t.split(",");
                    FruitTransaction.Operation operation =
                            defineOperationType(transactionInArray[OPERATION_INDEX]);
                    int quantity = Integer.parseInt(transactionInArray[QUANTITY_INDEX]);
                    return new FruitTransaction(operation, transactionInArray[FRUIT_INDEX],
                            quantity);
                })
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation defineOperationType(String type) {
        switch (type) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                return FruitTransaction.Operation.SUPPLY;
        }
    }
}
