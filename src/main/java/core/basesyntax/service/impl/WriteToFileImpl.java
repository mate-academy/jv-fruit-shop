package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImpl implements WriteToFile {

    @Override
    public String write(String report, String path) {
        Path filePath = Path.of(path);
        try {
            Files.writeString(filePath, report);
            return "Data was written to file " + filePath;
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + path, e);
        }
    }
}
