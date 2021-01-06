
package core.basesyntax.service.work.with.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadInformationFromFileImpl implements ReadInformationFromFile {
    public List<String> getAllLines(String fromFileName) {
        List<String> fruits;
        try {
            fruits = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot get data from file " + fromFileName);
        }
        return fruits.stream().skip(1)
                .collect(Collectors.toList());
    }
}

