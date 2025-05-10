package core.basesyntax.workwithfile;

import core.basesyntax.operations.FruitTransaction;
import core.basesyntax.workwithfileinterface.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            String[] parts = line.split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
