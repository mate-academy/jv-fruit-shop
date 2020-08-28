package core.basesyntax.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Reader {
    private static final String DIR_PATH = "/src/main/files/";

    public List<String> readFile(String fileName) throws IOException {
        String filePath = DIR_PATH.concat(fileName);
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
            Collections.sort(lines);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return lines;
    }
}
