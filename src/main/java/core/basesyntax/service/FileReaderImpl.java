package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> transactions;
        File inputFile = new File(filePath);
        try {
            transactions = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file " + filePath, e);
        }
        return transactions;
    }
}

