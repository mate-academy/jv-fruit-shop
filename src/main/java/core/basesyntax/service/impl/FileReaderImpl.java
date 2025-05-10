package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final int HEADERS_TYPE_INDEX = 0;

    @Override
    public List<String> read(String fileName) {
        List<String> transaction = new LinkedList<>();
        try {
            transaction = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from" + fileName, e);
        }
        transaction.remove(HEADERS_TYPE_INDEX);
        return transaction;
    }
}
