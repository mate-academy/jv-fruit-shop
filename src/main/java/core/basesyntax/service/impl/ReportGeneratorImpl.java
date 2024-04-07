package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.TreeMap;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_LINE_OF_INPUT_FILE = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String getReport() {
        Map<String, Integer> sortedFruitsMap = new TreeMap<>(Storage.remainsOfFruits);
        StringBuilder inputFileStringBuilder = new StringBuilder(FIRST_LINE_OF_INPUT_FILE);
        for (Map.Entry<String, Integer> entry : sortedFruitsMap.entrySet()) {
            inputFileStringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return inputFileStringBuilder.toString();
    }
}
