package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public interface ReadDataService {
    List<String> readFromFile(String fromFileName) throws IOException;
}
