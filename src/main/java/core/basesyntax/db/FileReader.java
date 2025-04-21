package core.basesyntax.db;

import java.util.List;

public interface FileReader {
    List<String> read(String filePath);
}
