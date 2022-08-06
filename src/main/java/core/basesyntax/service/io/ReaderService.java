package core.basesyntax.service.io;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String filePath);
}
