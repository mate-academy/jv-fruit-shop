package core.basesyntax.services.impl;

import core.basesyntax.services.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int SKIP_LINE = 1;

    @Override
    public List<String> readFromFile(String filename) {
        List<String> linesFromFile = new ArrayList<>();
        Path path = Paths.get(filename);
        try {
            Files.lines(path).skip(SKIP_LINE).forEach(linesFromFile::add);
        } catch(IOException e) {
            throw new RuntimeException("Can't read data from file : " + filename);
        }
        return linesFromFile;
    }
}
