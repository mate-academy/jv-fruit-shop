package core.basesyntax.model.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new RuntimeException("Ścieżka pliku jest null lub pusta");
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Nie można odczytać pliku: " + filePath, e);
        }
        return lines;
    }
}
