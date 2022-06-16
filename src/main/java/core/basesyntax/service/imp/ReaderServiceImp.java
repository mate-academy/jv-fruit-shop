package core.basesyntax.service.imp;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImp implements ReaderService {
    @Override
    public List<String> readRecords(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can`t open file " + path, e);
        }
    }
}
