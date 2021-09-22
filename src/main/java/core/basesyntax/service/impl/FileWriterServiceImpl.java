package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeToAFile(String data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file!");
        }
    }
}
