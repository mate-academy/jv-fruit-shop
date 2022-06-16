package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String[]> read(File input) {
        try (FileReader fileReader = new FileReader(input)) {
            try (CSVReader reader = new CSVReader(fileReader)) {
                List<String[]> csvEntries = reader.readAll();
                return csvEntries;
            } catch (CsvException e) {
                throw new RuntimeException("became wrong format, not csv file", e);
            }
        } catch (FileNotFoundException f) {
            throw new RuntimeException("file not fount", f);
        } catch (IOException i) {
            throw new RuntimeException("cant close properly the file", i);
        }
    }
}
