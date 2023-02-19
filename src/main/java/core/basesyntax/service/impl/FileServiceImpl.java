package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + filePath, e);
        }
    }

    @Override
    public void write(String toPath, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toPath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file " + toPath, e);
        }
    }
}
