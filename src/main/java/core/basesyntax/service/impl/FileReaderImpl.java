package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line = br.readLine();
            List<String> lines = new ArrayList<>();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
            return lines;
        } catch (IOException ex) {
            throw new RuntimeException("IOException has happened in the file: " + filePath, ex);
        }
    }
}
