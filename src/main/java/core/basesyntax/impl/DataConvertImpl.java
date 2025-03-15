package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConvertImpl implements DataConverter {
    static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] components = lines.get(i).split(SEPARATOR);
            if (components.length != 3) {
                throw new IllegalArgumentException("Invalid line format: " + lines.get(i));
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(components[0]);
            String fruit = components[1];
            int quantity = Integer.parseInt(components[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
