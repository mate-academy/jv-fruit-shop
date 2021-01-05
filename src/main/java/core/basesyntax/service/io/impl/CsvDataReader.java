package core.basesyntax.service.io.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import core.basesyntax.model.entities.Product;
import core.basesyntax.model.entities.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvDataReader<T extends Product> implements DataReader<T> {
    private final String inputFilePath;

    public CsvDataReader(String inputFilePath) {
        this.inputFilePath = inputFilePath;
        validateFileExtension();
    }

    @Override
    public void validateFileExtension() {
        if (!inputFilePath.endsWith(".csv")) {
            throw new InvalidFileExtensionException("This reader works with .csv files only");
        }
    }

    @Override
    public List<String[]> readData() {
        try (CSVReader csvReader =
                     new CSVReaderBuilder(Files.newBufferedReader(Paths.get(inputFilePath)))
                .withSkipLines(1)
                .build()) {
            return csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file", e);
        }
    }
}
