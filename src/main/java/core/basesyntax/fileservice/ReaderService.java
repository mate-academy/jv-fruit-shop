package core.basesyntax.fileservice;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String filePath);
}
