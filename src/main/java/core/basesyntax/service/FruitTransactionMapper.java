package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionMapper {

    public List<FruitTransaction> mapData(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Invalid data!");
        }

        for (int i = 1; i < lines.size(); i++) {
            String[] elements = lines.get(i).split(",");
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.findOperationByCode(elements[0]);
            String fruitName = elements[1];
            int quantity = Integer.parseInt(elements[2]);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(operation, fruitName, quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
