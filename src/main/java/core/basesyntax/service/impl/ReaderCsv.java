package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReaderCsv implements Reader {
    private static final String FILE_PATH = "src/files/fruits.csv";

    @Override
    public List<String> readData() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return DataProcessor.filterTitles(lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }

    static class DataProcessor {
        private static final Set<String> TITLES_TO_REMOVE = Set.of("type,fruit,quantity");

        public static List<String> filterTitles(List<String> data) {
            return data.stream()
                    .filter(row -> !TITLES_TO_REMOVE.contains(row))
                    .collect(Collectors.toList());
        }
    }
}
