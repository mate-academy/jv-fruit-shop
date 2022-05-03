package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteImpl implements Writer {
    @Override
    public boolean writeData(String data, String fileName) {
        try {
            Files.write(Path.of(fileName), data.getBytes());
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
