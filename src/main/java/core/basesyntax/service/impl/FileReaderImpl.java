package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    public static final String HEADER = "type,fruit,quantity";

    @Override
    public List<String> read(String filepath) {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(Path.of(filepath));
            strings.remove(HEADER);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read data from file " + filepath);
        }
        return strings;
    }
}
