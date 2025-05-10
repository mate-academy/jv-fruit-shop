package impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import service.ReadService;

public class ReadServiceImpl implements ReadService {
    private static final int INDEX = 1;

    @Override
    public List<String> read(String inputFile) {
        try {
            return Files.readAllLines(Path.of(inputFile))
                    .stream()
                    .skip(INDEX)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + inputFile);
        }
    }
}
