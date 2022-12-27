package core.basesyntax.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import core.basesyntax.service.WriteFile;

public class WriteCsvFileImpl implements WriteFile {
    @Override
    public void writeNewFile(String text, String createdFilePath) {
        try {
            Files.write( Paths.get(createdFilePath), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
