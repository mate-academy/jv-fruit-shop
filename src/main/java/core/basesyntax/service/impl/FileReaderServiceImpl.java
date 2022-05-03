package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readDataFromFiletoList(String path) {
        List<String> readFromFile = new LinkedList<>();
        try (Stream<String> lines = Files.lines(Path.of(path))) {
            readFromFile = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Cant`t read data from file", e);
        }
        return readFromFile;
    }
}
