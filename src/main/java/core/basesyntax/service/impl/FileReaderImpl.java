package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String SEPARATOR = ",";

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> dataFromFile = new ArrayList<>();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                dataFromFile = Files.readAllLines(Path.of(fileName));
            } catch (IOException e) {
                throw new RuntimeException("Can`t read from file: " + fileName);
            }
        }
        return dataFromFile;
    }
}
