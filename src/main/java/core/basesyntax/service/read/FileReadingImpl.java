package core.basesyntax.service.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadingImpl implements FileReading {
    @Override
    public List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the file: " + filePath, e);
        }
        return lines;
    }
}
