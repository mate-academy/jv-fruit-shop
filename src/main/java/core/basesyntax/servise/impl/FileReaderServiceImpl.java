package core.basesyntax.servise.impl;

import core.basesyntax.servise.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: " + file, e);
        }
    }
}
