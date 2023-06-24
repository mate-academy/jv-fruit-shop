package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> getDataFromCsv(String pathToResource) {
        try (Stream<String> data = Files.lines(Path.of(pathToResource))) {
            return data.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file by path: " + pathToResource, e);
        }
    }
}
