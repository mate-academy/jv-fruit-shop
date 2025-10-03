package core.basesyntax.service;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final String TYPE = "type";
    private static final int EXPECTED_COLUMNS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawLines) {
        if (rawLines == null) {
            throw new FruitShopException("Input lines are null");
        }

        List<FruitTransaction> result = new ArrayList<>();
        if (rawLines.isEmpty()) {
            return result;
        }

        int start = 0;
        if (rawLines.get(0).toLowerCase().startsWith(TYPE)) {
            start = 1;
        }

        for (int i = start; i < rawLines.size(); i++) {
            String line = rawLines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(COMMA);
            if (parts.length != EXPECTED_COLUMNS) {
                throw new FruitShopException(
                        "Invalid record format (expected "
                                + EXPECTED_COLUMNS + " values): " + line
                );
            }

            String opCode = parts[0].trim();
            String fruit = parts[1].trim();
            String qtyStr = parts[2].trim();

            try {
                Operation op = Operation.fromCode(opCode);
                int qty = Integer.parseInt(qtyStr);

                result.add(new FruitTransaction(op, fruit, qty));
            } catch (NumberFormatException nfe) {
                throw new FruitShopException(
                        "Invalid quantity number in line: " + line, nfe
                );
            } catch (RuntimeException e) {
                throw new FruitShopException(
                        "Can't parse line: " + line, e
                );
            }
        }

        return result;
    }
}
