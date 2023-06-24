package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    private static final String FILE_NAME = "order.csv";

    @Override
    public List<String> read() {
        List<String> informationFromFile;
        try {
            informationFromFile = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read information from file" + FILE_NAME);
        }
        return informationFromFile;
    }
}
