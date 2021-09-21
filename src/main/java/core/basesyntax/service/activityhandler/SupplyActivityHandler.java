package core.basesyntax.service.activityhandler;

import static core.basesyntax.db.Storage.storage;

public class SupplyActivityHandler implements ActivityTypeHandler {
    @Override
    public void processActivity(String fruit, Integer amount) {
        storage.put(fruit, storage.get(fruit) + amount);
    }
}
