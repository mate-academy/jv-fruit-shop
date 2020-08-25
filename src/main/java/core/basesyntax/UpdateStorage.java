package core.basesyntax;

import java.io.IOException;
import java.util.List;

public interface UpdateStorage {
    void parseFileToStorage(String fileName) throws IOException;

    void putLineToStorage(List<String> line);
}
