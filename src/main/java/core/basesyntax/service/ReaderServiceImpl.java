package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String[]> readFromFile(File file) {
        List<String> readRemnants;
        try {
            readRemnants = Files.readAllLines(Path.of(file.getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file");
        }
        return readRemnants.stream()
                .map(line -> line.split(","))
                .collect(Collectors.toList());
    }
}
