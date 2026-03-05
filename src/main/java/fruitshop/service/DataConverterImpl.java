package fruitshop.service;

import fruitshop.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputLines) {

        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputLines.size(); i++) {
            String line = inputLines.get(i);
            String[] parts = line.split(",");

            String operationCode = parts[0];
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(operationCode);

            FruitTransaction transaction =
                    new FruitTransaction(operation, fruit, quantity);

            transactions.add(transaction);
        }

        return transactions;
    }
}