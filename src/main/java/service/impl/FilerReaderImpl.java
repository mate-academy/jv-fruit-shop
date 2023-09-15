package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FilerReader;

public class FilerReaderImpl implements FilerReader {
    private static final String FILE_PATH = "src/main/resources/inputInfo.csv";

    @Override
    public List<String> dataToProcess() {
        List<String> fileInfo;
        try {
            fileInfo = Files.readAllLines(Path.of(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + FILE_PATH, e);
        }
        return fileInfo;
    }
}
