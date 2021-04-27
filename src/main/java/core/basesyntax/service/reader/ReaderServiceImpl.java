package core.basesyntax.service.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String inputDataFile) {
        Path filePath = Paths.get(inputDataFile);
        List<String> data = Collections.emptyList();
        try {
            data = Files.lines(filePath)
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + inputDataFile, e);
        }
        return data;
    }
}
