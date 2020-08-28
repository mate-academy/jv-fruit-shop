package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.IllegalFormatFlagsException;

public class DataParser {
    private static final String COMMA_DELIMITER = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int PRODUCT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int DATE_INDEX = 3;

    public Transaction parseLineToTransaction(String lineFromFile) {
        String[] line = lineFromFile.split(COMMA_DELIMITER);
        checkDataFormat(line);
        return new Transaction(line[PRODUCT_TYPE_INDEX], line[OPERATION_TYPE_INDEX],
                Integer.parseInt(line[QUANTITY_INDEX]), LocalDate.parse(line[DATE_INDEX]));
    }

    private void checkDataFormat(String[] lineFromFile) {
        if (!StoreOperations.containsOperation(lineFromFile[OPERATION_TYPE_INDEX])) {
            throw new IllegalFormatFlagsException("File provides unsupported operation type");
        }
        try {
            int fruitAmount = Integer.parseInt(lineFromFile[QUANTITY_INDEX]);
            LocalDate date = LocalDate.parse(lineFromFile[DATE_INDEX]);
        } catch (NumberFormatException | DateTimeParseException
                | ArrayIndexOutOfBoundsException message) {
            throw new IllegalArgumentException("File provides wrong data format");
        }
    }
}
