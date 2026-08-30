package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        if (lines == null || lines.isEmpty()) {
            return transactions;
        }
        for (String line : lines) {
            if (line == null) {
                continue;
            }
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            String lower = trimmed.toLowerCase();
            if (lower.startsWith("type,") || lower.startsWith("operation,")) {
                continue;
            }
            String[] parts = trimmed.split(",");
            if (parts.length < 3) {
                throw new RuntimeException("Malformed line (expected 3 parts): " + line);
            }
            String type = parts[0].trim();
            String fruit = parts[1].trim();
            if (fruit.isEmpty()) {
                throw new RuntimeException("Fruit name is empty in line: " + line);
            }
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2].trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity in line: " + line, e);
            }
            if (quantity < 0) {
                throw new RuntimeException("Negative quantity not allowed in line: " + line);
            }
            FruitTransaction.Operation op;
            try {
                op = FruitTransaction.Operation.fromCode(type);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Unknown operation code in line: " + line, e);
            }
            transactions.add(new FruitTransaction(op, fruit, quantity));
        }
        return transactions;
    }
}
