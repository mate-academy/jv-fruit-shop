package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader extends FileDataReader {
    @Override
    public List<String> read(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new RuntimeException("Failed to read data from a file."
                    + " Path is empty");
        }

        Path path = Paths.get(filePath);

        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file "
                    + filePath + ". File is not found.", e);
        }
    }
}
