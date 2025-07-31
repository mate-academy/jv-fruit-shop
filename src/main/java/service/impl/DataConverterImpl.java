package service.impl;

import model.FruitTransaction;
import service.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        boolean isFirstLine = true;
        for (String line : lines) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line: " + line);
            }
            String opCode = parts[0].trim();
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());
            if (quantity < 0) {
                throw new IllegalArgumentException("Negative quantity: " + line);
            }
            FruitTransaction.Operation op = FruitTransaction.Operation.fromCode(opCode);
            transactions.add(new FruitTransaction(op, fruit, quantity));
        }
        return transactions;
    }

    @Override
    public String toString() {
        return "DataConverterImpl{}";
    }
}
