package core.basesyntax.model.io;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");

            if (parts.length != 3) {
                continue;
            }

            FruitTransaction.Operation op =
                    FruitTransaction.Operation.fromCode(parts[0].trim());
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());
            transactions.add(new FruitTransaction(op, fruit, quantity));
        }
        return transactions;
    }
}
