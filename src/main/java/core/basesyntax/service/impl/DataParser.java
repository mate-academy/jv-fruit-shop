package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public List<String[]> parseLines(List<String> data) {
        List<String[]> parsedLines = new ArrayList<>();
        for (String line : data) {
            if (line.startsWith("type")) {
                continue; // пропустить заголовок
            }
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат строки: " + line);
            }
            parsedLines.add(parts);
        }
        return parsedLines;
    }
}
