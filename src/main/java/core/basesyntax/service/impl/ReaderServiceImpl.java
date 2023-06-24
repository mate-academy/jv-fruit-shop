package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading a file", e);
        }

        return stringBuilder.toString();
    }
}
