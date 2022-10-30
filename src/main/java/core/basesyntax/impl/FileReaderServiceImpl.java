package core.basesyntax.impl;

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
            file.createNewFile();
            report = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + fromFileName);
        }
        return report;
    }
}
