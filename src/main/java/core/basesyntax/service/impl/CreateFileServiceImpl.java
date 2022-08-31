package core.basesyntax.service.impl;

import core.basesyntax.service.CreateFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateFileServiceImpl implements CreateFileService {
    @Override
    public void createFile(String fileName) {
        if (Files.exists(Path.of(fileName))) {
            return;
        }
        try {
            Files.createFile(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + fileName, e);
        }
    }
}
