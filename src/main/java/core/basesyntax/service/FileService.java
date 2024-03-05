package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {
    public List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file from "
                    + this.getClass().getSimpleName(), e);
        }
    }

    public boolean writeReport(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.append(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
