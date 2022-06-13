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
    public List<String[]> readInput(File input) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(input));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("cant find file", e);
        }

        List<String[]> csvEntries = null;
        try {
            csvEntries = reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("cant read", e);
        } catch (CsvException e) {
            e.printStackTrace();
        }
        return csvEntries;
    }
}
