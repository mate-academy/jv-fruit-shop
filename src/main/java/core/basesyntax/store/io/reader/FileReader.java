package core.basesyntax.store.io.reader;

import java.util.List;

public interface FileReader {
    List<String> read(String fileName);
}
