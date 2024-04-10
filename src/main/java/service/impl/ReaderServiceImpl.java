package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFilesContents(String inputFile) {
        try (Stream<String> lines = Files.lines(Path.of(inputFile))) {
            Stream<String> dataWithoutFirstLine = lines.skip(1);
            return dataWithoutFirstLine.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file: " + inputFile, e);
        }
    }
}
