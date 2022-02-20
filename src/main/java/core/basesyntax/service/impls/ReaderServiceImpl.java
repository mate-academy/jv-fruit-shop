package core.basesyntax.service.impls;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String inputDataFile) {
        Path filePath = Paths.get(inputDataFile);
        try {
            return Files.lines(filePath)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + inputDataFile, e);
        }
    }
}
