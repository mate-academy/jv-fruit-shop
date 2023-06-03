package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readReport(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("can't read data from file: " + file);
        }
    }
}
