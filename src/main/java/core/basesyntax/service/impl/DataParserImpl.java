package core.basesyntax.service.impl;

import core.basesyntax.errors.DataParserError;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.DataParser;

public class DataParserImpl implements DataParser {
    private static final String SEPARATOR = ",";
    private static final int POSITION_OPERATION_TYPE = 0;
    private static final int POSITION_FRUIT = 1;
    private static final int POSITION_COUNT = 2;
    private static final int RIGHT_DATA_COLUMNS_COUNT = 3;

    @Override
    public Operation parse(String entry) {
        if (entry == null) {
            throw new DataParserError("Data entry is Null");
        }
        String[] parts = entry.split(SEPARATOR);
        if (parts.length != RIGHT_DATA_COLUMNS_COUNT) {
            throw new DataParserError("Invalid parameters count in row, need "
                    + RIGHT_DATA_COLUMNS_COUNT + ", available "
                    + parts.length);
        }
        OperationType operationType;
        try {
            operationType = OperationType.fromString(parts[POSITION_OPERATION_TYPE]);
        } catch (IllegalArgumentException e) {
            throw new DataParserError("Invalid operation type "
                    + parts[POSITION_OPERATION_TYPE], e);
        }
        int count;
        try {
            count = Integer.parseInt(parts[POSITION_COUNT]);
        } catch (NumberFormatException e) {
            throw new DataParserError("Count does not contain a parsable integer "
                    + parts[POSITION_COUNT], e);
        }
        if (count <= 0) {
            throw new DataParserError("Invalid count " + count);
        }
        return new Operation(operationType, parts[POSITION_FRUIT], count);
    }
}
