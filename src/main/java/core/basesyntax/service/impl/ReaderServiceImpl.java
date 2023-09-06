package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public static final String FILE_TYPE = ".csv";
    public static final int HEADER_INDEX = 0;

    @Override
    public List<String> readFromFile(Path filePath) {
        if (!filePath.toString().endsWith(FILE_TYPE)) {
            throw new RuntimeException("Wrong file type");
        }
        List<String> content;
        try {
            content = Files.readAllLines(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot get a file content", e);
        }
        content.remove(HEADER_INDEX);
        return content;
    }
}
