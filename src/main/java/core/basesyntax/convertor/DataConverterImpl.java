package core.basesyntax.convertor;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String line = inputReport.get(i);

            String[] parts = line.split(",");

            String type = parts[0];
            String fruit = parts[1];
            Integer quantity = Integer.parseInt(parts[2]);

            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(type);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);

            transactions.add(transaction);
        }
        return transactions;
    }
}
