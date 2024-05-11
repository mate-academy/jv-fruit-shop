package core.basesyntax.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private static final String COMMA_DELIMETER = ",";

    public static List<String[]> readLines(String path) {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(path).toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.split(COMMA_DELIMETER));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + path + " - " + e.getMessage());
        }
        return lines;
    }
}
