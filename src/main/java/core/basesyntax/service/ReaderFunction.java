package core.basesyntax.service;

import java.util.List;

public interface ReaderFunction {
    List<String> readFile(String filePath);
}
