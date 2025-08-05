package core.basesyntax.reader;

import java.util.List;

public interface FileReader {
    List<String> read(String filePath);
}
