package shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import shop.service.Reader;

public class CsvReaderImpl implements Reader {
    @Override
    public List<String> read(String fileName) {
        File fromFile = new File(fileName);
        if (!fromFile.exists()) {
            throw new RuntimeException("File doesn't exist");
        }
        try {
            return Files.readAllLines(fromFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file ", e);
        }
    }
}
