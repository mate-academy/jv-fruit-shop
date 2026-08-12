package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeFile(String content, String path) {
        try {
            Files.writeString(Paths.get(path), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't save file by path: " + path, e);
        }
    }
}
