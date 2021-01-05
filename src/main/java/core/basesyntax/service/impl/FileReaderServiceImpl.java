package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public String readFromFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + filePath, e);
        }
    }

    @Override
    public List<String> getDataFromFile(String filePath) {
        String[] strings = readFromFile(filePath).split(System.lineSeparator());
        String[] updatedData = new String[strings.length - 1];
        for (int i = 0; i < updatedData.length; i++) {
            updatedData[i] = strings[i + 1];
        }
        return Arrays.asList(updatedData);
    }
}
