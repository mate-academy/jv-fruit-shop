package core.shop.service.impl;

import core.shop.service.FileReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<String> read(String filename) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filename, e);
        }
    }
}
