package core.basesyntax;

import java.util.List;

public interface ReaderService {
    List<FruitTransaction> readFromFile(String filePath);
}
