package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import core.basesyntax.service.CsvFileReaderService;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {

    @Override
    public List<String[]> readFromFile(String filePath) {
        List<String[]> fileInfo;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            fileInfo = reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return fileInfo;
    }
}
