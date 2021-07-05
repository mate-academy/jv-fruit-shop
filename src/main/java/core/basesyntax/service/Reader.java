package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<String> readData(String sourceName) throws IOException;
}
