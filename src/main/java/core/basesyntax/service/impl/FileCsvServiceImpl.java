package core.basesyntax.service.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileCsvService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileCsvServiceImpl implements FileCsvService {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FRUIT_COLUMN_NAME = "Fruit";
    private static final String QUANTITY_COLUMN_NAME = "Quantity";

    @Override
    public List<String> readAllLines(String fileName) {
        File file = new File(RESOURCES + fileName);
        List<String> allLines;
        try {
            allLines = Files.readAllLines(Path.of(file.toURI()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + e);
        }
        return allLines;
    }

    @Override
    public void createReport(String fileName) {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{FRUIT_COLUMN_NAME, QUANTITY_COLUMN_NAME});
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruits().entrySet()) {
            String[] rowFromDB = new String[]{entry.getKey().getName(),
                    String.valueOf(entry.getValue())};
            data.add(rowFromDB);
        }
        try (CSVWriter csvWriter = new CSVWriter(
                new FileWriter(RESOURCES + fileName))) {
            csvWriter.writeAll(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't create CSV file " + e);
        }
    }

    @Override
    public CSVWriter createCsvFile(String fileName) {
        CSVWriter csvWriter;
        try {
            csvWriter = new CSVWriter(new FileWriter(RESOURCES + fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't create CSV file " + e);
        }
        return csvWriter;
    }
}
