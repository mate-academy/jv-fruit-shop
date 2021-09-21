package core.basesyntax.service.activityhandler;

import core.basesyntax.exceptions.OperationException;

import java.util.Map;

public class PurchaseActivityHandler implements ActivityTypeHandler {
    @Override
    public void processActivity(Map<String, Integer> storage,
                                String fruit, Integer amount) throws OperationException {
        if (storage.get(fruit) - amount < 0) {
            throw new OperationException("Not enough fruits in storage");
        }
        storage.put(fruit, storage.get(fruit) - amount);
    }
}
