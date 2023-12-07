package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    private final String EXCEPTION_MESSAGE_CANT_WRITE_TO_FILE = "Can't write to file";

    @Override
    public void writeToFile(String contentOfFile, String pathToFile) {
        try {
            Files.writeString(Path.of(pathToFile), contentOfFile);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE_CANT_WRITE_TO_FILE + pathToFile, e);
        }
    }
}
