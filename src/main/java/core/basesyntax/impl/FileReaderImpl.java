package core.basesyntax.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final int TITLE_LINE = 1;

    @Override
    public List<String> readFromFile(String pathToFile) {
        List<String> linesFromFile = new ArrayList<>();
        Path path = Paths.get(pathToFile);
        try {
            Files.lines(path).skip(TITLE_LINE).forEach(linesFromFile::add);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file" + pathToFile);
        }
        return linesFromFile;
    }
}
