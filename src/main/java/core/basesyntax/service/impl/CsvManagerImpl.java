package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.CsvManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvManagerImpl implements CsvManager {
    private static final String SPLIT_KEY = ",";
    private static final int ACTION_INDEX = 0;
    private static final int DATA_INDEX = 1;

    @Override
    public List<Transaction> read(String path) {
        List<Transaction> allLines = new ArrayList<>();
        try {
            List<String> allLinesString = Files.readAllLines(Paths.get(path));
            if (allLinesString.size() < 1) {
                throw new NullPointerException("File is empty: " + path);
            }
            for (int i = 1; i < allLinesString.size(); i++) {
                String[] line = allLinesString.get(i).split(SPLIT_KEY, 2);
                allLines.add(new Transaction(line[ACTION_INDEX], line[DATA_INDEX]));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + path);
        }
        return allLines;
    }

    @Override
    public void report(Map<String, Integer> report, String path) {
        File file = new File(path + "out.csv");
        StringBuilder builder = new StringBuilder();
        builder.append("fruit, quantity");
        report.forEach((key, value) -> builder
                .append(System.lineSeparator())
                .append(key).append(", ").append(value));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file);
        }
    }
}
