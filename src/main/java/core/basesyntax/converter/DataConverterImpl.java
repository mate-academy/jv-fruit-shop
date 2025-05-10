package core.basesyntax.converter;

import core.basesyntax.transaction.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> converterToTransaction(List<String> inputData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String data: inputData) {
            if (data.equals("type,fruit,quantity")) {
                continue;
            }
            String[] parts = data.split(",");
            String operationCode = parts[0].trim();
            String fruitName = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());

            // Determine the type of activity
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.fromCode(operationCode);

            // We create a new object and add it to the list
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruitName);
            transaction.setQuantity(quantity);
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}
