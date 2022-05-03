package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriting;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWritingImpl implements FileWriting {
    @Override
    public void writeToFile(String path, String report) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Writing file failed" + path, e);
        }
    }
}
