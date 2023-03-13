package core.basesyntax.service;

import core.basesyntax.model.Transaction;
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
    @Override
    //Returns a map in format "action" - "data"
    public List<Transaction> read(String path) {
        List<Transaction> allLines = new ArrayList<>();
        try {
            List<String> allLinesString = Files.readAllLines(Paths.get(path));
            if (allLinesString.size() < 1) {
                throw new NullPointerException("File is empty");
            }
            for (int i = 1; i < allLinesString.size(); i++) {
                String[] line = allLinesString.get(i).split(",", 2);
                allLines.add(new Transaction(line[0], line[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read ", e);
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
            throw new RuntimeException("Can't write ", e);
        }
    }
}
