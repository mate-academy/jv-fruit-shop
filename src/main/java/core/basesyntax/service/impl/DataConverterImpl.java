package core.basesyntax.service.impl;

import core.basesyntax.service.DataConverter;
import core.basesyntax.strategy.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public List<FruitTransaction> convertToTransaction(List<String> rawData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < rawData.size(); i++) {
            String[] parts = rawData.get(i).split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            fruitTransactions.add(new FruitTransaction(operation, fruit, quantity));
        }

        return fruitTransactions;
    }
}
