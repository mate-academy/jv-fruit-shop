package core.basesyntax.file.reader;

import java.util.List;

public interface FileReader {
    List<String> read(String filePath);
}
