package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public static final String FILE_TYPE = ".csv";

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> content;
        try {
            content = Files.readAllLines(Path.of(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot get a file content", e);
        }
        return content;
    }
}
