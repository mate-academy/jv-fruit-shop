package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> covertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            String[] parts = data.get(i).split(",");
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[0].trim());
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
