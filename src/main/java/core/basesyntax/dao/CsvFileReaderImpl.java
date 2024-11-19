package core.basesyntax.dao;

import core.basesyntax.model.Operation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public String[] read(String nameOfFile) {
        List<String> textInFile = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(nameOfFile))) {
            textInFile = Files.readAllLines(Path.of(nameOfFile));
            return textInFile.stream()
                    .filter(word -> word.startsWith(Operation.BALANCE.getCode())
                            || word.startsWith(Operation.PURCHASE.getCode())
                            || word.startsWith(Operation.RETURN.getCode())
                            || word.startsWith(Operation.SUPPLY.getCode()))
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the data from the file " + nameOfFile, e);
        }
    }
}
