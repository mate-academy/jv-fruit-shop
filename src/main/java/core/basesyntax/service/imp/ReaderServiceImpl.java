package core.basesyntax.service.imp;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        List<String> transactions;
        try {
            transactions = Files.readAllLines(Path.of(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file at" + file);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + file);
        }
        return transactions;
    }
}
