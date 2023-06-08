package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class DailyTransactionsStringToTransactions {
    public static final String SEPARATE_SYMBOL_FOR_CSV = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    public DailyTransactionsStringToTransactions() {
    }

    public List<Transaction> stringListToTransactionList(List<String> transactionListString) {
        return transactionListString.stream()
                .map(s -> s.split(SEPARATE_SYMBOL_FOR_CSV))
                .peek(s -> {
                    for (Operation operation : Operation.values()) {
                        if (s[OPERATION_INDEX].equals(operation.getOperation())) {
                            s[OPERATION_INDEX] = operation.name();
                        }
                    }
                    for (Fruit fruit : Fruit.values()) {
                        if (s[FRUIT_INDEX].equals(fruit.getFruitName())) {
                            s[FRUIT_INDEX] = fruit.name();
                        }
                    }
                })
                .map(t -> new Transaction(Operation.valueOf(t[OPERATION_INDEX]),
                        Fruit.valueOf(t[FRUIT_INDEX]),
                        Integer.parseInt(t[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
