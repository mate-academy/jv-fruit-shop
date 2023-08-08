package core.basesyntax.file.processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    public static final int USELESS_LINE = 0;
    private final String filePath;

    public CsvFileReaderImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> read() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }

        lines.remove(USELESS_LINE);
        return lines;
    }
}
