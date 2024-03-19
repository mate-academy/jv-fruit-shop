package core.basesyntax.utility.service;

import core.basesyntax.utility.Pair;
import java.util.List;

public interface FileService {
    List<String> readFromFile(String fileName);

    void writeToFile(String fileName, List<Pair<String, Integer>> data);
}
