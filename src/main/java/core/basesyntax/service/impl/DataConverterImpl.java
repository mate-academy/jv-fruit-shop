package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null) {
            throw new RuntimeException("Input data is null");
        }

        List<FruitTransaction> result = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) { // skip header
            String[] parts = lines.get(i).split(",");

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[0]);

            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (quantity < 0) {
                throw new RuntimeException("Negative quantity: " + quantity);
            }

            result.add(new FruitTransaction(operation, fruit, quantity));
        }

        return result;
    }
}

