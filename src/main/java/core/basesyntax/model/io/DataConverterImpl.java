package core.basesyntax.model.io;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Brak danych wejściowych do przetworzenia.");
        }

        List<FruitTransaction> transactions = new ArrayList<>();
        int lineNumber = 0;

        for (String line : lines) {
            lineNumber++;

            if (line == null || line.trim().isEmpty()) {
                throw new RuntimeException("Wiersz " + lineNumber + " jest pusty.");
            }

            String[] parts = line.split(",");

            if (parts.length != 3) {
                throw new RuntimeException("Incorrect row format " + lineNumber
                        + ": 3 fields expected, found " + parts.length);
            }

            String opCode = parts[0].trim();
            String fruit = parts[1].trim();
            String quantityStr = parts[2].trim();

            if (opCode.isEmpty()) {
                throw new RuntimeException("No operation code in the line " + lineNumber);
            }

            FruitTransaction.Operation op;
            try {
                op = FruitTransaction.Operation.fromCode(opCode);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Unknown operation code " + opCode
                        + " in line " + lineNumber);
            }

            if (fruit.isEmpty()) {
                throw new RuntimeException("There is no fruit name in the line " + lineNumber);
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Incorrect quantity '" + quantityStr
                        + " in line " + lineNumber);
            }

            if (quantity < 0) {
                throw new RuntimeException("Negative quantity" + quantity + " in line "
                        + lineNumber + " for fruit " + fruit + "'");
            }

            transactions.add(new FruitTransaction(op, fruit, quantity));
        }
        return transactions;
    }
}
