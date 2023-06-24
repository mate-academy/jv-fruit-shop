package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeData(String data, String filePath) {
        File file = new File(filePath);
        try {
            Files.writeString(file.toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filePath, e);
        }
    }
}
