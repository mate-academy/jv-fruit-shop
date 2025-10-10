package core.basesyntax.serviceimpl;

import core.basesyntax.common.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new RuntimeException("Input report cannot be null");
        }
        if (inputReport.isEmpty()) {
            throw new RuntimeException("Input report cannot be empty");
        }

        String header = inputReport.get(0).trim();
        if (!header.equalsIgnoreCase("type,fruit,quantity")) {
            throw new RuntimeException("Invalid or missing CSV header. "
                    + "Expected: 'type,fruit,quantity'");
        }

        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String line = inputReport.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] lineArray = line.split(",");
            if (lineArray.length != 3) {
                throw new RuntimeException("Invalid CSV format at line " + (i + 1)
                        + ": expected 3 columns but got " + lineArray.length + " -> " + line);
            }

            String code = lineArray[0].trim();
            String fruit = lineArray[1].trim();
            if (fruit.isEmpty()) {
                throw new RuntimeException("Fruit name cannot be empty at line "
                        + (i + 1) + ": " + line);
            }

            int quantity;
            try {
                quantity = Integer.parseInt(lineArray[2].trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity at line " + (i + 1)
                        + ": must be an integer -> " + line, e);
            }

            if (quantity < 0) {
                throw new RuntimeException("Quantity cannot be negative at line "
                        + (i + 1) + ": " + line);
            }

            FruitTransaction.Operation operation;
            try {
                operation = FruitTransaction.Operation.fromCode(code);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Unknown operation code '" + code + "' at line "
                        + (i + 1) + ": " + line, e);
            }

            if (operation == null) {
                throw new RuntimeException("Invalid operation code '" + code + "' at line "
                        + (i + 1) + ": " + line);
            }

            fruitTransactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactions;
    }
}
