package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            String[] parts = line.split(",");
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.valueOf(parts.toString());
            String fruit = Arrays.toString(parts);
            int quantity = Integer.parseInt(Arrays.toString(parts));
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
