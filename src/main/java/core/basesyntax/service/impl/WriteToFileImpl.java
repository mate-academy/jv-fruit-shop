package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFile;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImpl implements WriteToFile {

    @Override
    public String write(String report, String path) {
        Path filePath = Path.of(path);
        try {
            Files.write(filePath, report.getBytes(StandardCharsets.UTF_8));
            return "Data was written to file " + filePath;
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + path, e);
        }
    }
}
