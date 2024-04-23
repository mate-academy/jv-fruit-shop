package core.basesyntax.service.storage;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StorageService {
    void transfer(List<FruitTransaction> fruits, FruitStorage storage);
}
