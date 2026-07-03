package core.converter;

import core.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Input file is empty");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).isBlank()) {
                continue;
            }
            String[] splits = lines.get(i).split(",");
            if (splits.length != 3) {
                throw new RuntimeException("Invalid CSV row: " + lines.get(i));
            }
            FruitTransaction.Operation currentOperation =
                    FruitTransaction.Operation.fromCode(splits[0]);
            String fruit = splits[1];
            if (fruit.isBlank()) {
                throw new RuntimeException("Fruit name can't be empty");
            }
            int quantity = Integer.parseInt(splits[2]);
            if (quantity < 0) {
                throw new RuntimeException("Quantity can't be negative: " + quantity);
            }
            FruitTransaction transaction = new FruitTransaction(currentOperation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
