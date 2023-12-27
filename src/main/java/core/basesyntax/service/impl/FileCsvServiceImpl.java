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
    private static final String NEW_LINE = "\n";

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
    public void writeToFile(String path, String data) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(path))) {
            List<String[]> records = convertStringToListStringsArray(data);
            csvWriter.writeAll(records, false);
        } catch (IOException e) {
            throw new RuntimeException("Can't create CSV file " + e);
        }
    }

    private List<String[]> convertStringToListStringsArray(String data) {
        List<String[]> result = new ArrayList<>();
        String[] records = data.split(NEW_LINE);
        for (String record : records) {
            result.add(record.split(COMA));
        }
        return result;
    }
}
