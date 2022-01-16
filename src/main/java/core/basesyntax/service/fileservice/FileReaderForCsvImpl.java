package core.basesyntax.service.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderForCsvImpl implements FileReader {

    @Override
    public List<String> readAllLinesFromFile(String fromFile) {
        try {
            return Files.readAllLines(Path.of(fromFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fromFile, e);
        }
    }
}
