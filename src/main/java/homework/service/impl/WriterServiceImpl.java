package homework.service.impl;

import homework.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void csvWrite(Path path, String string) {
        try {
            Files.writeString(path, string);
        } catch (IOException e) {
            throw new RuntimeException("Can't writ to file: " + path, e);
        }
    }
}
