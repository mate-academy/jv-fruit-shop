package core.basesyntax.parser;

import java.util.List;

public interface FileReader {
    List<String> read(String filePath);
}
