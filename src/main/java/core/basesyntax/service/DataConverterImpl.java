package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            String[] parts = line.split(",");
            Operation operation = Operation.fromCode(parts[TYPE_INDEX]);
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
