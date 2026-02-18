package core.basesyntax;

import java.util.*;
import core.basesyntax.FruitTransaction.Operation;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for(String line : lines) {
            String[] parts = line.split(",");
            String code = parts[0];
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            Operation operation = Operation.fromCode(code);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);

        }
        return transactions;
    }
}
