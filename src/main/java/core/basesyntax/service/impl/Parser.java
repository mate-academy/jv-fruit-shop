package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String HEADER = "type,fruit,quantity";
    private static final String DELIMITER = ",";

    public List<String[]> parse(List<String> inputReport) {
        List<String[]> parsedData = new ArrayList<>();
        for (String line : inputReport) {
            if (line.equals(HEADER)) {
                continue;
            }
            String[] parts = line.split(DELIMITER);
            parsedData.add(parts);
        }
        return parsedData;
    }
}
