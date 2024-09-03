package core.basesyntax.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl {
    private static final String FILE_NAME = "input.csv";

    public List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
        return new ArrayList<>(lines);
    }
}
