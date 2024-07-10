package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private final DataConverter dataConverter;

    public FileReaderImpl() {
        this.dataConverter = new DataConverterImpl();
    }

    @Override
    public List<String> read(String fileName) throws IOException {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new IOException("Failed to read file: " + fileName, e);
        }
    }

    public List<FruitTransaction> readTransactions(String filePath) throws IOException {
        List<String> lines;
        try {
            lines = read(filePath);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + filePath, e);
        }

        return dataConverter.convertToTransaction(lines);
    }
}
