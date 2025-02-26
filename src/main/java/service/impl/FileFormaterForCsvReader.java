package service.impl;

import java.util.ArrayList;
import java.util.List;
import service.FileFormater;

public class FileFormaterForCsvReader implements FileFormater {
    private static final int COLUMNS_AMOUNT = 3;

    @Override
    public List<String[]> format(String data) {
        List<String[]> result = new ArrayList<>();
        String[] columns = data.split(",");
        if (columns.length % COLUMNS_AMOUNT != 0) {
            throw new IllegalArgumentException("Missing data in one of the row, please check it");
        }
        for (int i = 0; i < columns.length; i += COLUMNS_AMOUNT) {
            String[] row = new String[COLUMNS_AMOUNT];
            System.arraycopy(columns, i, row, 0, COLUMNS_AMOUNT);
            result.add(row);
        }
        return result;
    }
}
