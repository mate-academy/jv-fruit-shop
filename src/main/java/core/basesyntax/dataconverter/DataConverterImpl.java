package core.basesyntax.dataconverter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : data) {
            String[] fields = line.split(",");

            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(fields[0]);
            String fruit = fields[1];
            int quantity = Integer.parseInt(fields[2]);

            FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
