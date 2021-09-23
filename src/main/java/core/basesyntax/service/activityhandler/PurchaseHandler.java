package core.basesyntax.service.activityhandler;

import core.basesyntax.exceptions.NotEnoughFruitsInStorageException;
import java.util.Map;

public class PurchaseHandler implements ActivityHandler {
    @Override
    public void processActivity(Map<String, Integer> storage,
                                String fruit,
                                Integer amount) throws NotEnoughFruitsInStorageException {
        if (storage.get(fruit) - amount < 0) {
            throw new NotEnoughFruitsInStorageException("Not enough fruits in storage");
        }
        storage.put(fruit, storage.get(fruit) - amount);
    }
}
