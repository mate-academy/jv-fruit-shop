package core.basesyntax;

import java.util.List;

public interface DataReader {
    List<String> readFromFile(String path);
}
