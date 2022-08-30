package core.basesyntax.serviceImpl;

import core.basesyntax.service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int INDEX_TITLE_LINE = 0;

    @Override
    public List<String> readData(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        }catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
        lines.remove(INDEX_TITLE_LINE);
        return lines;
    }
}
