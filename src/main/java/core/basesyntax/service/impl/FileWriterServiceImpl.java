package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String CANT_WRITE_TO_FILE = "Can't write to file.";

    @Override
    public void writeToFile(String text, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(text + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(CANT_WRITE_TO_FILE);
        }
    }
}
