package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFileWriterImpl implements MyFileWriter {
    @Override
    public void write(String data, String filePath) {
        try {
            Files.write(Paths.get(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write file by path: " + filePath, e);
        }
    }
}
