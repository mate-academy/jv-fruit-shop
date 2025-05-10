package core.basesyntax.service.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.service.FileCsvService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileCsvServiceImpl implements FileCsvService {
    private static final String COMA = ",";

    @Override
    public List<String> readFile(String path) {
        File file = new File(path);
        List<String> allLines;
        try {
            allLines = Files.readAllLines(Path.of(file.toURI()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + e);
        }
        return allLines;
    }

    @Override
    public void writeToFile(String path, List<String> data) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(path))) {
            List<String[]> records = new ArrayList<>();
            for (String record : data) {
                records.add(record.split(COMA));
            }
            csvWriter.writeAll(records, false);
        } catch (IOException e) {
            throw new RuntimeException("Can't create CSV file " + e);
        }
    }
}
