package core.basesyntax.strategу;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;

public class PlusStrategy implements Strategy {
    StorageService storageService = new StorageServiceImpl();
    @Override
    public void execute(String fruit, Integer amount) {
        storageService.plus(fruit, amount);
    }
}
