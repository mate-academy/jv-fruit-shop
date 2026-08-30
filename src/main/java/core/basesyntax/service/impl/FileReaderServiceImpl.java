package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))) {
            String line = br.readLine(); // читаємо і пропускаємо заголовок
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // пропускаємо порожні рядки
                }
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + filePath, e);
        }
        return lines;
    }
}
