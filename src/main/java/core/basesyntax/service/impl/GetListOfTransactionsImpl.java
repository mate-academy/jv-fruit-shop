package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.GetListOfTransactions;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetListOfTransactionsImpl implements GetListOfTransactions {
    private static final String SPLIT_SYMBOL = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> getListOfTransactions(String data) {
        return Arrays.stream(data.split(System.lineSeparator()))
                .skip(1)
                .map(this::stringToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction stringToFruitTransaction(String transaction) {
        String[] split = transaction.split(SPLIT_SYMBOL);
        FruitTransaction fruitTransaction = new FruitTransaction
                .FruitTransactionBuilder()
                .setOperation(stringToOperation(split[OPERATION_INDEX]))
                .setFruitType(split[FRUIT_TYPE_INDEX])
                .setAmount(Integer.parseInt(split[AMOUNT_INDEX]))
                .build();
        return fruitTransaction;
    }

    private Operation stringToOperation(String operation) {
        Operation[] values = Operation.values();
        for (Operation e : values) {
            if (e.getOperation().equals(operation)) {
                return e;
            }
        }
        throw new RuntimeException("Can`t find operation " + operation);
    }
}
