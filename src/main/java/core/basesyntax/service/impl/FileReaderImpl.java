package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFile(File fileName) {
        try {
            fileName.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + fileName, e);
        }
        try {
            return Files.readAllLines(fileName.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + fileName, e);
        }
    }
}
