package core.basesyntax.service.impl;

import core.basesyntax.service.FileWrite;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteImpl implements FileWrite {
    @Override
    public void writeToCsv(String data, String fileName) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}
