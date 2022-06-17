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
        try (CSVReader reader = new CSVReader(new FileReader(input))) {
            List<String[]> fileReaded = reader.readAll();
            fileReaded.remove(0);
            return fileReaded;
        } catch (CsvException e) {
            throw new RuntimeException("became wrong format, not csv file: " + input, e);
        } catch (FileNotFoundException f) {
            throw new RuntimeException("file not found: " + input, f);
        } catch (IOException i) {
            throw new RuntimeException("cant close properly the file: " + input, i);
        }
    }
}
