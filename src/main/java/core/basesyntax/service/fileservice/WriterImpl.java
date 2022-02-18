package core.basesyntax.service.fileservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterImpl implements Writer {
    public void write(String fileName, String data) {
        try {
            Files.write(new File(fileName).toPath(), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cann`t write to file " + fileName, e);
        }
    }
}
