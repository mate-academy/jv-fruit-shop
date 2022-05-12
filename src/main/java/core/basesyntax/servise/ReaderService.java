package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ReaderService {
    List<FruitTransaction> readFromCsv(String filePath);
}
