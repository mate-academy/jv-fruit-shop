package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(String fromFile) {
        try {
            return Files.readAllLines(Path.of(fromFile));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + fromFile, e);
        }
    }

    @Override
    public void write(String toFile, String report) {
        try {
            Files.writeString(Path.of(toFile), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + toFile, e);
        }
    }
}
