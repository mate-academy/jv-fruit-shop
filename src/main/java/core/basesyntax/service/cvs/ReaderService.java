package core.basesyntax.service.cvs;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String filePath);
}
