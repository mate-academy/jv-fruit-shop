package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> fileToStringList(Path filePath) {
        List<String> list;
        try {
            list = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath,e);
        }
        list.remove(0);
        return list;
    }
}
