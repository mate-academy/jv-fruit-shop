package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionMapper {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OFFSET = 1;

    public List<FruitTransaction> mapData(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Invalid data!");
        }
        for (int i = OFFSET; i < lines.size(); i++) {
            String[] elements = lines.get(i).split(SEPARATOR);
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.findOperationByCode(elements[OPERATION_INDEX]);
            String fruitName = elements[FRUIT_INDEX];

            int quantity = Integer.parseInt(elements[QUANTITY_INDEX]);

            FruitTransaction fruitTransaction =
                        new FruitTransaction(operation, fruitName, quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
