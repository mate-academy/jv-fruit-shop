package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

public class CsvFileReader implements FileReader {

    @Override
    public String readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }

            return data.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file " + Path.of(path).toFile(), e);
        }
    }
}
