package core.basesyntax.infrastructure.db;

import java.util.List;

public interface FileReader {
    List<String> read(String fileName);
}
