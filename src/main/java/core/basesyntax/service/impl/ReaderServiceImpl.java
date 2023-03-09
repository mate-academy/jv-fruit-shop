package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readInfoFromFile(File inputFile) {
        List<String> inputData;
        try {
            inputData = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + inputFile);
        }
        return inputData;
    }
}
