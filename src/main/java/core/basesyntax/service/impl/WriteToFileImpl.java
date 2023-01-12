package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeFile(Path path, String data) {
        try {
            Files.write(path, data.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + path, e);
        }
    }
}
