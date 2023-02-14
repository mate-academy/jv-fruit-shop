package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String fromFileName) {
        File file = new File(fromFileName);
        List<String> report;
        try {
            report = Files.readAllLines(file.toPath());
            return report;
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + fromFileName);
        }
    }
}
