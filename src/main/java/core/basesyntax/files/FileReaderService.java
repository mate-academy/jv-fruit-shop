package core.basesyntax.files;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String filePath);
}
