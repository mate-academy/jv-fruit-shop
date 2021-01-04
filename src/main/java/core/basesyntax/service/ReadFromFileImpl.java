package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {

    private static final int HEADING_LINE = 0;

    @Override
    public List<String> readFromFile(String fileName) {
        try {
            List<String> result = new ArrayList<>();
            result = Files.readAllLines(new File(fileName).toPath());
            result.remove(HEADING_LINE);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
