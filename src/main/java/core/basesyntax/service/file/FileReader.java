package core.basesyntax.service.file;

import java.util.List;

public interface FileReader {
    List<String> readFromFile(String path);
}
