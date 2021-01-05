package core.basesyntax.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import core.basesyntax.exception.ReadFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader implements FilesReader {
    @Override
    public List<String[]> read(String fileName) {
        try (CSVReader reader = new CSVReaderBuilder(Files.newBufferedReader(Paths.get(fileName)))
                .withSkipLines(1).build()) {
            return reader.readAll();
        } catch (IOException e) {
            throw new ReadFileException("Can't read read file " + fileName);
        }
    }
}
