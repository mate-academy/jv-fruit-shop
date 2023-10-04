package core.basesyntax.services.imps;

import core.basesyntax.services.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReaderServiceImp implements ReaderService {
    private static final String LINE_SPLITERATOR = "/";

    @Override
    public String readFromFile(String sourceFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            return bufferedReader.lines().collect(Collectors.joining(LINE_SPLITERATOR));
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + sourceFile, e);
        }
    }
}
