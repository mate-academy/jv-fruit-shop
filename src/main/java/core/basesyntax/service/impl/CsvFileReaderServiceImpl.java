package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFile(File file) {
        List<String> readFile;
        try {
            readFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(
                    "non-valid file");
        }
        if (!readFile.get(0).equals("type,fruit,quantity")) {
            throw new RuntimeException(
                    "the structure of file must match type,fruit,quantity");
        }
        return readFile
                .stream()
                .skip(1)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
