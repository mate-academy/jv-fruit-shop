package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements core.basesyntax.service.FileReader {

    @Override
    public List<String> processFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            try {
                throw new IOException("Error reading file: " + filePath, e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return lines;
    }
}
