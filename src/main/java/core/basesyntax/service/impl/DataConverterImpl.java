package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        if (lines == null) {
            throw new RuntimeException("Lines can't be null");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.getByCode(parts[0]);
            int quantity = Integer.parseInt(parts[2]);
            if (quantity < 0) {
                throw new RuntimeException("Quantity can't be negative");
            }
            transactions.add(new FruitTransaction(operation, parts[1], quantity));
        }
        return transactions;
    }
}
