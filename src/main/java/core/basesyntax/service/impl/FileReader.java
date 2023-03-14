package core.basesyntax.service.impl;

import java.util.List;

public interface FileReader {
    List<String[]> readFromFile(String pathToFile);
}
