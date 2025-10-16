package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        Objects.requireNonNull(report, "report must not be null");

        return IntStream.range(0, report.size())
                .mapToObj(i -> {
                    String line = report.get(i);
                    int lineNumber = i + 1;
                    if (line == null || line.isBlank()) {
                        throw new IllegalArgumentException("Line "
                                + lineNumber + " is empty or null");
                    }
                    String[] parts = line.split(COMMA_SEPARATOR, -1);
                    if (parts.length != 3) {
                        throw new IllegalArgumentException(
                                "Line " + lineNumber 
                                        + " must contain exactly 3 fields but has "
                                        + parts.length + ": \"" + line + "\"");
                    }
                    String opToken = parts[0].trim();
                    String fruit = parts[1].trim();
                    String qtyToken = parts[2].trim();
                    FruitTransaction.Operation operation;
                    try {
                        operation = FruitTransaction.Operation.fromCode(opToken);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException(
                                "Unknown operation code '"
                                        + opToken + "' on line "
                                        + lineNumber + ": \"" + line + "\"", e);
                    }
                    int quantity = getQuantity(qtyToken, lineNumber, line);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .toList();
    }

    private int getQuantity(String qtyToken, int lineNumber, String line) {
        int quantity;
        try {
            quantity = Integer.parseInt(qtyToken);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Invalid quantity '" + qtyToken + "' on line "
                            + lineNumber
                            + ": must be an integer. Line: \""
                            + line + "\"", e);
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Negative quantity " + quantity + " on line " + lineNumber + ": \"" + line + "\"");
        }
        return quantity;
    }
}
