package core.basesyntax.service.impl;

import core.basesyntax.service.FIleWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FIleWriter {
    @Override
    public void writeFile(String csvFilePath, byte[] reportData) {
        try {
            if (csvFilePath == null) {
                throw new RuntimeException("File path can`t be null");
            }
            Files.write(Path.of(csvFilePath), reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file");
        }
    }
}
