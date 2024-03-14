package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    private static final String TITLE = "type,fruit,quantity";

    @Override
    public String read(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(TITLE)) {
                    stringBuilder.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return stringBuilder.toString();
    }
}
