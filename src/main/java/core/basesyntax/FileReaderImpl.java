package core.basesyntax;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        try {
            Path filePath = Path.of(path);
            List<String> lines = Files.readAllLines(filePath);

            if (!lines.isEmpty()) {
                lines.remove(0);
            }
            return lines;

        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + path, e);
        }
    }
}
