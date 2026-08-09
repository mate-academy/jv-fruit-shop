package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.OperationType;
import core.basesyntax.service.IDataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverter implements IDataConverter {

    public List<FruitTransaction> convertData(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : data) {
            if (line == null || line.isBlank()) {
                continue;
            }

            String[] parts = line.split(",");

            if (parts.length != 3) {
                continue;
            }

            String fruit = parts[1].trim();

            if (fruit.isEmpty()) {
                continue;
            }

            try {
                OperationType operation = OperationType.fromCode(parts[0].trim());
                int quantity = Integer.parseInt(parts[2].trim());
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (IllegalArgumentException e) {
                //SKIP THE LINE
            }
        }

        return transactions;
    }
}
