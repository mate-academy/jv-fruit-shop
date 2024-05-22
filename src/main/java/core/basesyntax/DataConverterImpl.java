package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data.subList(1, data.size())) {
            String[] parts = line.split(",");
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.valueOf(parts[0].toUpperCase());
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
