package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl {
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < inputReport.size(); i++) {
            String[] parts = inputReport.get(i).split(",");
            String type = parts[0];
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.valueOf(type.toUpperCase());
            FruitTransaction transaction =
                    new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}

