package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        Path filePath = Paths.get(fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
        return lines;
    }

    @Override
    public void writeToFile(String fileName, String text) {
        Path filePath = Paths.get(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath)) {
            bufferedWriter.append(text);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
    }
}
