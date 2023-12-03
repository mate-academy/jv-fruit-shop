package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionMapper {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    public List<FruitTransaction> mapData(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Invalid data!");
        }

        for (int i = 1; i < lines.size(); i++) {
            String[] elements = lines.get(i).split(SEPARATOR);
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.findOperationByCode(elements[OPERATION]);
            String fruitName = elements[FRUIT];
            int quantity = Integer.parseInt(elements[QUANTITY]);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(operation, fruitName, quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
