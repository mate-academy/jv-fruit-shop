package core.basesyntax.dao;

import java.util.List;

public interface FileReader {
    List<String> read(String filePath);
}
