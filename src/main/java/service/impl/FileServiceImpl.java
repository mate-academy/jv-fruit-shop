package service.impl;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String fromFileName) {
        try {
            return Files.readAllLines(Path.of(fromFileName));
        } catch (Exception e) {
            throw new RuntimeException("Can`t read from file " + fromFileName, e);
        }
    }

    @Override
    public void writeToFile(List<String> lines, String toFileName) {
        Path path = Paths.get(toFileName);
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Can't write the file" + toFileName, e);
        }
    }
}
