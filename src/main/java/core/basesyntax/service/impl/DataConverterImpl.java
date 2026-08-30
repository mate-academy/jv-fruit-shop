package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            FruitTransaction.Operation op = FruitTransaction.Operation.fromCode(parts[0]);
            transactions.add(new FruitTransaction(op, parts[1], Integer.parseInt(parts[2])));
        }
        return transactions;
    }
}
