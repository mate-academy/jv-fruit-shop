package core.basesyntax.service;

import java.util.List;

public interface ReaderService {
    List<String> readFile(String filePath);

    List<String> readFile(String filePath, int linesAmountToSkip);
}
