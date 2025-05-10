package core.basesyntax.service.impl;

import core.basesyntax.service.WriteCsv;
import exception.FileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteCsvImpl implements WriteCsv {
    @Override
    public void writeToFile(String path, String data) {
        try {
            Files.writeString(Path.of(path), data);
        } catch (IOException e) {
            throw new FileException("Can`t write data to file by path " + path);
        }
    }
}
