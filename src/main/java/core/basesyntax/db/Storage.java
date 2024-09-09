package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public Integer getQuantity(String fruit) {
        return fruits.get(fruit);
    }

    public void put(String fruit, Integer quantity) {
        fruits.put(fruit, quantity);
    }

    public Set<String> keyset() {
        return fruits.keySet();
    }
    /*
    The SupplyOperation class should not directly access and manipulate the Storage class.
    This violates the SOLID principles, specifically the Single Responsibility Principle,
    because it couples the operation logic with the storage mechanism.
    Consider abstracting the storage access behind
    a service layer that this operation would then call.
     */

}
