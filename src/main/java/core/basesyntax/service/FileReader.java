package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader implements Readable {

    @Override
    public String readFile(File fromFile) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFile))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }

            return data.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file " + fromFile.getName(), e);
        }
    }
}
