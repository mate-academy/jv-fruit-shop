package core.basesyntax.service.converting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<String> getInfoFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file --> " + fileName);
        }
    }
}
