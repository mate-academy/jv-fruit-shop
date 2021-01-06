package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.WriteToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void write(String path, String output) {
        try {
            Files.writeString(Path.of(path), output);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
