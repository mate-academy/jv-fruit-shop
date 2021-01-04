package core.basesyntax.service.io.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import core.basesyntax.model.entities.Product;
import core.basesyntax.service.io.DataImporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVDataImporter<T extends Product> implements DataImporter<T> {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";

    @Override
    public List<String[]> importData() {
        try (CSVReader csvReader = new CSVReaderBuilder(Files.newBufferedReader(Paths.get(INPUT_FILE_PATH)))
                .withSkipLines(1)
                .build()) {
            return csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file", e);
        }
    }
}
