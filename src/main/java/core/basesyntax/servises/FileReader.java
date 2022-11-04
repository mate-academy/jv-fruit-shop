package core.basesyntax.servises;

import java.util.List;

public interface FileReader {
    List<String> readFromFile(String path);
}
