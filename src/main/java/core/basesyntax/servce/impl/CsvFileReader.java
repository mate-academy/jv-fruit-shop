package core.basesyntax.servce.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.servce.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CsvFileReader implements FileReader {
    private static final int NUMBER_OF_MISSING_LINES = 1;
    @Override
    public List<String[]> readCsvFile(String fileName) {
        try (CSVReader csvReader = new CSVReaderBuilder(new java.io.FileReader(fileName))
                .withSkipLines(NUMBER_OF_MISSING_LINES)
                .build()) {
            return csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't read this file: " + fileName, e);
        }
    }
}
