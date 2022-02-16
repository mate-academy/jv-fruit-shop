package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> read(String sourceFile) {
        try {
            return Files.readAllLines(Paths.get(sourceFile));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file by the path ", e);
        }
    }

    @Override
    public void write(String reportFile, String report) {
        try {
            Files.write(Paths.get(reportFile), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file by the path ", e);
        }
    }
}
