package core.basesyntax.service;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public interface WriterService {
    void writeToCsv(List<FruitTransaction> list, String filePath);
}
