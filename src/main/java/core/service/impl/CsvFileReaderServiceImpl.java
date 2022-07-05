package core.service.impl;

import core.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(File file) {
        try {
            List<String> strings = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            strings.remove(0);
            return strings;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file " + file, e);
        }
    }
}
