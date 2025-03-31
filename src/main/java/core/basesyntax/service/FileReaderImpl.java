package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl {

    public static List<String[]> processFile(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length == 3) {
                    data.add(row);
                } else {
                    System.err.println("Invalid row format, skipping: " + line);
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + filePath, e);
        }
        return data;
    }
}
