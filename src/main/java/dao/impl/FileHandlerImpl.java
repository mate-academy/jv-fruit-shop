package dao.impl;

import dao.FileHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHandlerImpl implements FileHandler {
    @Override
    public List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read a file", e);
        }
    }

    @Override
    public void writeFile(String filename, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter((filename)))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file", e);
        }
    }
}
