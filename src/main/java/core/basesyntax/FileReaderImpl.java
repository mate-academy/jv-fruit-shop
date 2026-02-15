package core.basesyntax;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        Path filePath = Path.of(path);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath);

            if (!lines.isEmpty()) {
                lines.remove(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!lines.isEmpty()) {
            lines.remove(0);
        }
    }
}
