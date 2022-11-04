package core.basesyntax.servises.impl;

import core.basesyntax.servises.WriteToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void write(String report, String path) {
        try {
            Files.write(Path.of(path), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file" + e);
        }
    }
}
