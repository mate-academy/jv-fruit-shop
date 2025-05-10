package core.basesyntax.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    private static final String PATH = "src/main/resources/db/database.csv";
    private static final int TITLE_IN_FILE = 0;
    private static final Path filePath = Path.of(PATH);

    public List<String> readFile() {

        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: "
                    + filePath, e);
        }
        if (!lines.isEmpty()) {
            lines.remove(TITLE_IN_FILE);
        }
        return lines;
    }
}
