package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    // only the method shown
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();
        if (lines == null || lines.isEmpty()) {
            return result;
        }
        for (String raw : lines) {
            if (raw == null) {
                continue;
            }
            String line = raw.trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.toLowerCase().startsWith("type,") || line.toLowerCase().startsWith("type;")) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length < 3) {
                throw new IllegalArgumentException("Invalid input line (expect 3 columns): "
                        + line);
            }
            final String fruit = parts[1].trim();
            final String quantityStr = parts[2].trim();
            final String code = parts[0].trim(); // move declaration close to usage and make final

            if (fruit.isEmpty()) {
                throw new IllegalArgumentException("Fruit name is empty in line: " + line);
            }
            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity in line: "
                        + line, e);
            }
            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity must be non-negative in line: "
                        + line);
            }
            FruitTransaction.Operation op = FruitTransaction.Operation.fromCode(code);
            result.add(new FruitTransaction(op, fruit, quantity));
        }
        return result;
    }
}
