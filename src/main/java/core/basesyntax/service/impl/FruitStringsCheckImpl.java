package core.basesyntax.service.impl;

import core.basesyntax.exception.DataFileCorrupted;
import core.basesyntax.service.interfaces.FruitStringsCheck;
import java.util.List;

public class FruitStringsCheckImpl implements FruitStringsCheck {
    private static final int EXPECTED_COLUMN_COUNT = 3;

    @Override
    public boolean checkFruitQuantity(List<String> rawStrings) {
        if (rawStrings == null || rawStrings.isEmpty()) {
            return false;
        }
        String headerLine = rawStrings.get(0);
        String[] headerColumns = headerLine.split(",");
        if (headerColumns.length != EXPECTED_COLUMN_COUNT) {
            throw new DataFileCorrupted("Header row is missing");
        }
        for (String line : rawStrings.subList(1, rawStrings.size())) {
            String[] columns = line.split(",");
            if (columns.length != EXPECTED_COLUMN_COUNT) {
                throw new DataFileCorrupted("Data rows is missing, expected "
                + EXPECTED_COLUMN_COUNT
                + " but only "
                + columns.length
                + " is present");
            }
            for (String column : columns) {
                if (column == null || column.trim().isEmpty()) {
                    throw new DataFileCorrupted("Data in column is absent");
                }
            }
        }
        return true;
    }
}
