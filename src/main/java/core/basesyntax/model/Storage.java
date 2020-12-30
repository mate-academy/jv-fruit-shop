package core.basesyntax.model;

import java.util.Map;

public abstract class Storage<T> {
    private Map<T, Integer> storage;
    
    public Storage(Map<T, Integer> storage) {
        this.storage = storage;
    }
    
    public Map<T, Integer> getStorage() {
        return storage;
    }
    
    public void setStorage(Map<T, Integer> storage) {
        this.storage = storage;
    }
}
