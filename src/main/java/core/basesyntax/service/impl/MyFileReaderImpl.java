package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MyFileReaderImpl implements MyFileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t reading from file : " + fileName, e);
        }
    }
}
