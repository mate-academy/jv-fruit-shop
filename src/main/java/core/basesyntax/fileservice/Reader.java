package core.basesyntax.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class Reader {
    public static final int FIRST_ELEMENT_INDEX = 0;
    private final String dirPath;

    public Reader(String dirPath) {
        this.dirPath = dirPath;
    }

    public List<String> readFile(String fileName) throws IOException {
        if (fileName == null) {
            throw new NoSuchFileException("No such file found");
        }
        String filePath = dirPath.concat(fileName);
        List<String> lines;
        lines = Files.readAllLines(Path.of(filePath));
        lines.remove(FIRST_ELEMENT_INDEX);
        return lines;
    }
}
