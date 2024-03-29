package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationService;

public class SupplyOperation implements OperationService {
    @Override
    public void operation(String line) {
        String[] meaning = line.split(",");
        Storage.storage.replace(
                meaning[1], Storage.storage.get(meaning[1]) + Integer.valueOf(meaning[2]));
    }
}
