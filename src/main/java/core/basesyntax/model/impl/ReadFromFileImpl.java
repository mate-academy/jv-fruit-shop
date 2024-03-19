package core.basesyntax.model.impl;

import core.basesyntax.model.service.ReadFromFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("can`t read file");
        }
    }
}
