package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriteService;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeFile(String fileName, String content) {
        try {
            Files.write(Path.of(fileName), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
