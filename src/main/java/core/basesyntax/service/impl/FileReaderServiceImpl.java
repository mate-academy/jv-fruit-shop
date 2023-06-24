package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String FILE_HEADER = "type,fruit,quantity";
    private static final int INDEX_OF_FILE_HEADER = 0;

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> transactionInfo;
        try {
            transactionInfo = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName);
        }

        if (transactionInfo.isEmpty()) {
            throw new RuntimeException("There is no data in file to read " + fileName);
        }
        if (FILE_HEADER.equals(transactionInfo.get(INDEX_OF_FILE_HEADER))) {
            transactionInfo.remove(INDEX_OF_FILE_HEADER);
        }
        return transactionInfo;
    }
}
