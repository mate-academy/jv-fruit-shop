package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",", -1);

            if (parts.length != 3) {
                throw new RuntimeException("Invalid transaction format: " + line);
            }

            String code = parts[0];
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            FruitTransaction.Operation operation = Arrays
                    .stream(FruitTransaction.Operation.values())
                    .filter(op -> op.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Unknown operation: " + code));

            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(operation);
            fruitTransaction.setFruit(fruit);
            fruitTransaction.setQuantity(quantity);

            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
