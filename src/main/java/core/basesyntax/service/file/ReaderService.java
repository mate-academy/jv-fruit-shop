package core.basesyntax.service.file;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String filePath);
}
