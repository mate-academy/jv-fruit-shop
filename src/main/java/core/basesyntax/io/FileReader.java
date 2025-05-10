package core.basesyntax.io;

import java.util.List;

public interface FileReader {
    List<String> readFile(String filePath);
}
