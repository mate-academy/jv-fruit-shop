package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.IOException;

public class CSvReader extends FileReader {
    @Override
    public String readFile(String fromFileName) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFileName))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }
            return data.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }
}
