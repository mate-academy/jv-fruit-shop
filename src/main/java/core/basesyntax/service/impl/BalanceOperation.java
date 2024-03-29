package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationService;

public class BalanceOperation implements OperationService {
    @Override
    public void operation(String line) {
        String[] meaning = line.split(",");
        Storage.storage.put(meaning[1], Integer.valueOf(meaning[2]));
    }
}
