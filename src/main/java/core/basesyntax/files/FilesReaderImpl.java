package core.basesyntax.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FilesReaderImpl implements FilesReader {
    public static final int USELESS_LINE = 0;
    @Override
    public List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }

        if (!lines.isEmpty()) {
            lines.remove(USELESS_LINE);
        }

        return lines;
    }
}