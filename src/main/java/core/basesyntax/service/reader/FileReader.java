package core.basesyntax.service.reader;

import java.util.List;

public interface FileReader {
    List<String> read(String filePath);
}
