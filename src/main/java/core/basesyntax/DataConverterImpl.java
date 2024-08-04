package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith("type")) {
                continue; // skip header
            }
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line format: " + line);
            }
            Operation operation;
            try {
                operation = findOperation(parts[0]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unknown operation code: " + parts[0]);
            }
            String fruit = parts[1];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format: " + parts[2]);
            }
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            transactions.add(transaction);
        }
        return transactions;
    }

    private Operation findOperation(String code) {
        for (Operation op : Operation.values()) {
            if (op.getCode().equalsIgnoreCase(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }
}
