package core.basesyntax.reader;

import java.util.List;

public interface Reader {
    List<List<String>> read(String filePath);
}
