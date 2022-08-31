package homework.dao.impl;

import homework.dao.WriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriteService {
    @Override
    public void csvWrite(Path path, String string) {
        try {
            Files.writeString(path, string);
        } catch (IOException e) {
            throw new RuntimeException("Can't writ to file: " + path, e);
        }
    }
}
