package core.basesyntax.service.file.reader;

import java.util.List;

public interface FileReader {
    List<String> readFromFile(String path);
}
