package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWorker implements Reader, Writer {
    @Override
    public List<String> readFrom(String filePath) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data readFrom file: " + filePath, e);
        }
        return dataFromFile;
    }

    @Override
    public void write(String data, String filePath) {
        try {
            Files.write(Path.of(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data write file: " + filePath, e);
        }
    }
}
