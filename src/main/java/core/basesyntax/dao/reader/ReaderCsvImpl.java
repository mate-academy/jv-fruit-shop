package core.basesyntax.dao.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderCsvImpl implements ReaderCsv {

    @Override
    public List<String> read(Path fileName) {
        List<String> transactions = new ArrayList<>();
        try {
            transactions = Files.readAllLines(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + fileName, e);
        }
        return transactions;
    }
}
