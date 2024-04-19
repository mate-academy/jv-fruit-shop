package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String text, String fileName) {
        try {
            Files.write(Paths.get("src/main/resources/" + fileName + ".csv"), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write a report" + e);
        }
    }
}
