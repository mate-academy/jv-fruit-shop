package core.basesyntax.impl;

import core.basesyntax.services.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> linesFromFile = new ArrayList<>();
        Path path = Paths.get(fileName);
        try {
            Files.lines(path).skip(1).forEach(linesFromFile::add);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file : " + fileName);
        }
        return linesFromFile;
    }
}
