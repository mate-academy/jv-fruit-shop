package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderServiceImpl implements FileReaderService {
    private String filePath;

    public FileReaderServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + filePath, e);
        }
    }

    @Override
    public String[] getDataFromFile(String filePath) {
        FileReaderService fileReaderService = new FileReaderServiceImpl(filePath);
        String[] strings = fileReaderService.readFromFile().split(System.lineSeparator());
        String[] updatedData = new String[strings.length - 1];
        for (int i = 0; i < updatedData.length; i++) {
            updatedData[i] = strings[i + 1];
        }
        return updatedData;
    }
}
