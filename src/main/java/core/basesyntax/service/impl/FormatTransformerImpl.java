package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FormatTransformer;

import java.util.ArrayList;
import java.util.List;

public class FormatTransformerImpl implements FormatTransformer {
    public List<FruitTransaction> formatData(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            String[] values = line.split(",");
            if (values.length == 3) {
                String operation = values[0].trim();
                FruitTransaction.Operation operation1 = FruitTransaction.Operation.getByCode(operation);
                String fruit = values[1].trim();
                int quantity = Integer.parseInt(values[2].trim());
                FruitTransaction transaction = new FruitTransaction(operation1, fruit, quantity);
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}

