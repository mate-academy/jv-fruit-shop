package core.basesyntax.dao;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : report.subList(0, report.size())) {
            String[] parts = line.split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.valueOf(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
