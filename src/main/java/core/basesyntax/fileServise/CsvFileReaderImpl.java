package core.basesyntax.fileServise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> getTransactionsFromFile(String fileName) {
        List<String> transactions;
        try {
            transactions = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("can't read file " + fileName);
        }
        return transactions;
    }
}

