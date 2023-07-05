package core.shop.service.impl;

import core.shop.service.FileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(String filename) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filename, e);
        }
    }

    @Override
    public void write(String fileName, String info) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(info);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file" + fileName, e);
        }
    }
}
