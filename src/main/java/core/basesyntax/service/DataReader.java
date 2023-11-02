package core.basesyntax.service;

import java.util.List;

public interface DataReader {
    List<String> readFile(String pathToFile);
}
