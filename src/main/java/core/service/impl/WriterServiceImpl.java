package core.service.impl;

import core.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeTo(Path path, List<String> list) {
        try {
            Files.write(path, list);
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to the file.", e);
        }
    }
}
