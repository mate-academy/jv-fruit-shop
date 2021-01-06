package core.basesyntax.model.abstractstorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStorage<R, I extends AbstractItem> {
    private final Map<I, Integer> storage = new HashMap<>();
    
    public abstract void initStorage(List<R> records);
    
    public Map<I, Integer> getStorage() {
        return storage;
    }
}
