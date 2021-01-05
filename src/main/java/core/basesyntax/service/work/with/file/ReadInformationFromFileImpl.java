
package core.basesyntax.service.work.with.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadInformationFromFileImpl implements ReadInformationFromFile {
    public List<String> getAllLines(String fileName) {
        List<String> fruits;
        try {
            fruits = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot get data from file " + fileName);
        }
        return fruits;
    }
}

