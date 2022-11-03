package core.basesyntax.service.impl;

import core.basesyntax.service.FIleWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileWriterImpl implements FIleWriter {
    @Override
    public void writeFile(String scvFilePath, byte[] reportData ) {
        try {
            if (scvFilePath == null) {
                throw new RuntimeException("File path can`t be null");
            }
            Files.write(Path.of(scvFilePath), reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file");
        }
    }
}
