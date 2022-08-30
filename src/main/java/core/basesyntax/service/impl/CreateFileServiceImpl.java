package core.basesyntax.service.impl;

import core.basesyntax.service.CreateFileServise;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateFileServiceImpl implements CreateFileServise {
    @Override
    public void createFile(String fileName) {
        try {
            Files.createFile(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }
    }
}
