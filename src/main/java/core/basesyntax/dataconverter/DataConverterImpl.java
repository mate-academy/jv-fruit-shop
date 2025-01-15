package core.basesyntax.dataconverter;

import core.basesyntax.FruitTransaction;
import core.basesyntax.FruitTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputReport) {
            if (line.contains("type")) {
                continue;
            }

            String[] array = line.split(",");
            Operation operation = Operation.getOperation(array[0]);
            String fruit = array[1];
            int quantity = Integer.parseInt(array[2]);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
