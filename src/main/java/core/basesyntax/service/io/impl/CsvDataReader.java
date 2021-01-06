package core.basesyntax.service.io.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import core.basesyntax.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvDataReader implements DataReader {

    @Override
    public List<String[]> readData(Path pathToFile) {
        validateFileExtension(pathToFile);
        try (CSVReader csvReader =
                     new CSVReaderBuilder(Files.newBufferedReader(pathToFile))
                .withSkipLines(1)
                .build()) {
            return csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file", e);
        }
    }

    private boolean validateFileExtension(Path pathToFile) {
        if (!pathToFile.toString().endsWith(".csv")) {
            throw new InvalidFileExtensionException("This reader works with .csv files only");
        }
        return true;
    }
}
