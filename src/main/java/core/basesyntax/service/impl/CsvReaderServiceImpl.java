package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {
    private File file;

    public CsvReaderServiceImpl(String filePath) {
        file = new File(filePath);
    }

    @Override
    public List<String> getLines() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader.lines().toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read from file: " + file);
        }
    }
}
