package core.basesyntax.service.util;

import core.basesyntax.model.OperationType;

public class CsvRowValidator {
    private static final String OPERATION_CODES = OperationType.getAllCodes();
    private static final String CSV_ROW_PATTERN =
            "[" + OPERATION_CODES + "]" + ",[a-zA-Z]+,\\d+" + "(\\n)?";

    public static boolean validate(String row) {
        return row != null && row.matches(CSV_ROW_PATTERN);
    }
}
