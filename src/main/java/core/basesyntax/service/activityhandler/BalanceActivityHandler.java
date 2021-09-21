package core.basesyntax.service.activityhandler;

import core.basesyntax.exceptions.OperationException;

import java.util.Map;

public class BalanceActivityHandler implements ActivityTypeHandler {
    @Override
    public void processActivity(Map<String, Integer> storage,
                                String fruit, Integer amount) {
        storage.put(fruit, amount);
    }
}
