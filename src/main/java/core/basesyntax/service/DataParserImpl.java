package core.basesyntax.service;

import core.basesyntax.errors.DataParserError;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationType;

public class DataParserImpl implements DataParser {
    private static final String SEPARATOR = ",";

    @Override
    public Operation parse(String entry) {
        if (entry == null) {
            throw new DataParserError("Data entry is Null");
        }
        String[] parts = entry.split(SEPARATOR);
        if (parts.length != 3) {
            throw new DataParserError("Invalid parameters count in row, need 3, available "
                    + parts.length);
        }
        OperationType operationType;
        try {
            operationType = OperationType.fromString(parts[0]);
        } catch (IllegalArgumentException e) {
            throw new DataParserError("Invalid operation type " + parts[0], e);
        }
        int count;
        try {
            count = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new DataParserError("Count does not contain a parsable integer "
                    + parts[2], e);
        }
        if (count <= 0) {
            throw new DataParserError("Invalid count " + count);
        }
        return new Operation(operationType, parts[1], count);
    }
}
