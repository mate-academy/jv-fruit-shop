package core.service.impl;

import core.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(File file) {
        try {
            return Files.readAllLines(file.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file " + file, e);
        }
    }
}
