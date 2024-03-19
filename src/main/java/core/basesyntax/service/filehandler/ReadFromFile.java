package core.basesyntax.service.filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public String readFromFile(String filePath) {
        File readFile = new File(filePath);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(readFile))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        return builder.toString();
    }
}
