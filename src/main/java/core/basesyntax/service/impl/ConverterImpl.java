package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Converter;
import java.util.ArrayList;
import java.util.List;

public class ConverterImpl implements Converter {
    private static final int EXPECTED_FIELDS = 3;

    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != EXPECTED_FIELDS) {
                throw new RuntimeException("Wrong format of the line " + (i + 1));
            }

            String operationSymbol = parts[0].trim();
            String fruit = parts[1].trim();
            String quantityLine = parts[2].trim();

            Operation operation = Operation.parseOperation(operationSymbol, i);

            int quantity;
            try {
                quantity = Integer.parseInt(quantityLine);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Incorrect number in a line " + (i + 1), e);
            }

            if (quantity < 0) {
                throw new RuntimeException("Quantity can't be negative");
            }

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
