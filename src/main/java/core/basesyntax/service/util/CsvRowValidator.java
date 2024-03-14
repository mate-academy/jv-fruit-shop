package core.basesyntax.service.util;

public class CsvRowValidator {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_VALUE_COLUMN = 2;

    public static void validate(String row, int expectedColumns) {
        if (row == null) {
            throw new IllegalArgumentException("Row is null");
        }
        String[] columns = row.split(SEPARATOR);
        if (columns.length != expectedColumns) {
            throw new IllegalArgumentException("Invalid number of columns in row: " + row);
        }
        if (columns[OPERATION_VALUE_COLUMN] == null
                || !columns[OPERATION_VALUE_COLUMN].matches("\\d+")
                || Integer.parseInt(columns[OPERATION_VALUE_COLUMN]) < 0) {
            throw new IllegalArgumentException("Invalid operation value in row: " + row);
        }
    }
}
