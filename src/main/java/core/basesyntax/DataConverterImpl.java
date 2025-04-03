package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter{
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(DELIMITER);
            if (parts.length != 3) {
                throw new IllegalArgumentException("!!");
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
