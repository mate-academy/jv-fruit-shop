package core.basesyntax.service;

import java.io.FileWriter;
import java.io.IOException;

public class FIleWriterServiceImpl implements FIleWriterService {
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
