package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileWriteServiceImpl implements FileWriteService {
    @Override
    public void writeToFile(Path path, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + path, e);
        }
    }
}
