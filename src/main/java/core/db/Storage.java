package core.db;

import java.util.Map;
import java.util.Optional;

public interface Storage {
    void put(String key, Integer value);
    
    Optional<Integer> getQuantity(String key);
    
    boolean contains(String fruit);
    
    Map<String, Integer> getStorage();
}
