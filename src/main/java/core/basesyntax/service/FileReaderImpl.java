package core.basesyntax.service;

import core.basesyntax.exception.NoSuchFileInPathException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private List<String> transactions = new ArrayList<>();

    @Override
    public List<String> readFromFile(Path path) {
        try {
            transactions = Files.readAllLines(path);
        } catch (IOException e) {
            throw new NoSuchFileInPathException("Can't read data from file " + path);
        }
        return transactions;
    }
}
