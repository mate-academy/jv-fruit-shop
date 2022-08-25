package core.basesyntax.clear;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClearDataImpl implements ClearData {
    @Override
    public void clearDataIfExist(String fileReport) {
        try {
            Files.deleteIfExists(Path.of(fileReport));
        } catch (IOException e) {
            throw new RuntimeException("Can't clear data before tests", e);
        }
    }
}
