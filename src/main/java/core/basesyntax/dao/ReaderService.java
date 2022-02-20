package core.basesyntax.dao;

import java.util.List;

public interface ReaderService {
    List<String> getDataFromFile(String filePath);
}
