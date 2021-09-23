package core.basesyntax.service.activityhandler;

import core.basesyntax.exceptions.NotEnoughFruitsInStorageException;
import java.util.Map;

public interface ActivityHandler {
    void processActivity(Map<String, Integer> storage,
                         String fruit, Integer amount) throws NotEnoughFruitsInStorageException;
}
