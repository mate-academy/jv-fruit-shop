package core.basesyntax.service.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String data) {
        Path path = Paths.get(data);
        try {
            return Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + data, e);
        }
    }
}
