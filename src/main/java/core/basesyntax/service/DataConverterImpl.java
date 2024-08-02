package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputReport) {
            if (line.startsWith("type")) {
                continue; // skip header line
            }
            String[] parts = line.split(",");
            Operation operation = Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
