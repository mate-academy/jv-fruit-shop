package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    Map<String, Integer> storageFruits = Storage.fruits;

    void handle(FruitTransaction transaction);

}
