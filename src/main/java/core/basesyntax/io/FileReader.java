package core.basesyntax.io;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static final String PATH = "src/main/resources/db/";
    private static final String INPUT_FILE_NAME = "database.csv";
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int TITLE_IN_FILE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int LENGTH_ONE_LINE = 3;

    public List<FruitTransaction> readFile() {
        Path filePath = Path.of(PATH + INPUT_FILE_NAME);
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: "
                    + filePath, e);
        }
        if (!lines.isEmpty()) {
            lines.remove(TITLE_IN_FILE);
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            try {
                transactions.add(getFromCsvRow(line));
            } catch (IllegalArgumentException e) {
                System.err.println("Skipping invalid line: "
                        + line + " Error: " + e.getMessage());
            }
        }
        return transactions;
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(SEPARATOR);
        if (fields.length < LENGTH_ONE_LINE) {
            throw new IllegalArgumentException("Invalid data format, "
                    + "expected at least 3 fields.");
        }
        Operation operation = parseOperation(fields[OPERATION]);
        String fruit = fields[FRUIT].trim();
        BigDecimal quantity = parseQuantity(fields[QUANTITY]);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private Operation parseOperation(String operationField) {
        try {
            return Operation.fromCode(operationField.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation type.");
        }
    }

    private BigDecimal parseQuantity(String quantityField) {
        try {
            return new BigDecimal(quantityField.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity value.");
        }
    }
}
