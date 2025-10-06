package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {

    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty");
        }

        List<FruitTransaction> result = new ArrayList<>();
        int lineNum = 0;

        for (String raw : lines) {
            lineNum++;
            if (raw == null) {
                throw new IllegalArgumentException("Null line at: " + lineNum);
            }

            String line = raw.trim();

            if (lineNum == 1) {
                if (!line.equalsIgnoreCase(HEADER)) {
                    throw new IllegalArgumentException("Invalid header: " + line);
                }
                continue;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line at " + lineNum + ": " + line);
            }

            String code = parts[0].trim();
            String fruit = parts[1].trim();
            int qty;

            try {
                qty = Integer.parseInt(parts[2].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity at line " + lineNum);
            }

            result.add(new FruitTransaction(FruitTransaction.Operation.fromCode(code), fruit, qty));
        }

        return result;
    }
}
