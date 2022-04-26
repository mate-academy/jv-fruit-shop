package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {

    @Override
    public List<String> fileReader(String fileName) {
        List<String> filesData;
        File file = new File(fileName);
        try {
            filesData = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't get this file " + fileName);
        }
        return filesData;
    }
}
