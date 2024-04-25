package core.basesyntax.dao.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderCsvImpl implements ReaderCsv {

    @Override
    public List<String> read(Path fileName) {
        try {
            return Files.readAllLines(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + fileName, e);
        }
    }
}
