package core.basesyntax.file.processing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextDataReadingImpl implements TextDataReading {
    public static final String FILE_PATH = "src/main/resources/";
    public static final String FILE_FROM_NAME = "database.csv";
    public static final int USELESS_LINE = 0;

    @Override
    public List<String> read() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + FILE_FROM_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + FILE_PATH + FILE_FROM_NAME, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        lines.remove(USELESS_LINE);
        return lines;
    }
}
