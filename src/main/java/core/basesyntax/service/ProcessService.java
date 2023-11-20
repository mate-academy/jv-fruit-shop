package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessService {
    Storage processObjects(List<FruitTransaction> data);
}
