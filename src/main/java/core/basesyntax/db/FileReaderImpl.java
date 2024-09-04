package core.basesyntax.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl extends FileReader {
    public FileReaderImpl(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
        return lines;
    }
}
