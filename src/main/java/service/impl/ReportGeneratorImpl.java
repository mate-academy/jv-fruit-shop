package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.ReportCreator;

public class ReportGeneratorImpl implements ReportCreator {
    public static final String FIRST_COLUMN_UPDATED_UPDATED = "fruit";
    public static final String SECOND_COLUMN_UPDATED_UPDATED = "quantity";

    @Override
    public List<String[]> createReport(Map<String, Integer> data) {
        List<String[]> fruitsList = new ArrayList<>();
        fruitsList.add(new String[]{FIRST_COLUMN_UPDATED_UPDATED, SECOND_COLUMN_UPDATED_UPDATED});
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            fruitsList.add(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }
        return fruitsList;
    }
}
