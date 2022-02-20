package core.basesyntax.service.activityhandler;

import java.util.Map;

public class ReturnHandler implements ActivityHandler {
    @Override
    public void processActivity(Map<String, Integer> storage,
                                String fruit, Integer amount) {
        storage.put(fruit, storage.get(fruit) + amount);
    }
}
