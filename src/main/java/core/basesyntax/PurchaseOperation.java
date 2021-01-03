package core.basesyntax;

import java.util.Map;

public class PurchaseOperation implements Operation {
    @Override
    public void execute(String fruit, Integer amount) {
        Map<String, Integer> storage = Warehouse.getStorage();
        storage.put(fruit, storage.get(fruit) - amount);
    }
}
