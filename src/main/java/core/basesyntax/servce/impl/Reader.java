package core.basesyntax.servce.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.servce.CsvFileReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader implements CsvFileReader {
    @Override
    public List<String[]> readCsvFile() {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(FILE_NAME))
                .withSkipLines(1)
                .build()) {
            return csvReader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + FILE_NAME, e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException("CSV library creates this exception.", e);
        }
    }
}
