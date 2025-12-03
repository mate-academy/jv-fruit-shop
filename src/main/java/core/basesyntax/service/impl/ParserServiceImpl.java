package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> getFromCsvRow(List<String> csvRows) {
        List<FruitTransaction> result = new ArrayList<>();

        if (csvRows == null) {
            throw new IllegalArgumentException("The file contains no data");
        }

        for (int i = 1; i < csvRows.size(); i++) {
            String[] parts = csvRows.get(i).split(",");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid data format in line: "
                        + csvRows.get(i));
            }
            Operation operation = Operation.fromCode(parts[0]);
            String fruit = parts[1];

            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity value: '" + parts[2] + "' in line: "
                        + csvRows.get(i), e);
            }

            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity can't be negative: " + quantity);
            }
            result.add(new FruitTransaction(operation, fruit, quantity));
        }
        return result;
    }
}
