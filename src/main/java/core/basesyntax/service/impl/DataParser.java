package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final int EXPECTED_PARTS_LENGTH = 3;

    public List<String[]> parseLines(List<String> data) {
        List<String[]> parsedLines = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith("type")) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length != EXPECTED_PARTS_LENGTH) {
                throw new IllegalArgumentException("Неверный формат строки: " + line);
            }
            parsedLines.add(parts);
        }
        return parsedLines;
    }
}
