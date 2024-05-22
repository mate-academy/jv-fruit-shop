package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String PATH_TO_RESOURCES = "src/main/resources/";
    private static final String FILE_FORMAT = ".csv";

    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("File name can't be null!");
        }
        if (!filePath.endsWith(FILE_FORMAT)) {
            throw new IllegalArgumentException("File must be a .csv format!");
        }
        try {
            return Files.readAllLines(Paths.get(PATH_TO_RESOURCES + filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
