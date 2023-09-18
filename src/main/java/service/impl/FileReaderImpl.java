package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    private static final int HEADER_LINES_QUANTITY = 1;

    @Override
    public List<String> dataToProcess(String filePath) {
        try (Stream<String> fileInfo = Files.lines(Paths.get(filePath))) {
            return fileInfo
                    .skip(HEADER_LINES_QUANTITY)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }
}
