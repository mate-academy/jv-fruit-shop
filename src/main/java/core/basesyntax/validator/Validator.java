package core.basesyntax.validator;

import core.basesyntax.OperationType;
import java.util.Arrays;
import java.util.function.Predicate;

public class Validator implements Predicate<String[]> {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUITS_AMOUNT = 2;

    @Override
    public boolean test(String[] record) {
        if (record.length != 3) {
            throw new RuntimeException("Record isn`t full! Incorrect input in record: "
                    + Arrays.toString(record));
        }
        if (Integer.parseInt(record[FRUITS_AMOUNT]) < 0) {
            throw new RuntimeException("Incorrect operation value: " + record[FRUITS_AMOUNT]
                    + " for operation - "
                    + OperationType.getEnumValue(record[OPERATION_TYPE]));
        }
        return true;
    }
}
