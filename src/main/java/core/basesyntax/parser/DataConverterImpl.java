package core.basesyntax.parser;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> input) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < input.size(); i++) {
            String[] parts = input.get(i).split(",");

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getOperationByCode(parts[0]);

            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }

        return transactions;
    }
}
