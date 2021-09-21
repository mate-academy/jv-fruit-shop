package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    public static final String HEADER = "type,fruit,quantity";

    @Override
    public List<String> readFile(String filepath) {
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
