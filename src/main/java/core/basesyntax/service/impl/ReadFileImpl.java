package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileImpl implements ReadFile {

    @Override
    public List<String> getData(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cant read file" + fileName, e);
        }
        return lines;
    }
}
