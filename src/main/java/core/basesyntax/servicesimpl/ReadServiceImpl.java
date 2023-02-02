package core.basesyntax.servicesimpl;

import core.basesyntax.services.ReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadServiceImpl implements ReadService {
    public static final int ACTIVITY_INDEX = 1;

    @Override
    public List<String> read(String inputFile) {
        try {
            return Files.readAllLines(Path.of(inputFile))
                    .stream()
                    .skip(ACTIVITY_INDEX)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from " + inputFile, e);
        }
    }
}
