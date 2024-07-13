package serviceImpl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;

class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            try {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Invalid input line: " + line);
                }

                Operation operation = Operation.fromCode(parts[0]);
                String fruit = parts[1];
                int quantity;
                try {
                    quantity = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid quantity: " + parts[2] + " in line: " + line, e);
                }

                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Error processing line: " + line);
            }
        }
        return transactions;
    }
}

