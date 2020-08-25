package core.basesyntax;

import java.time.LocalDate;
import java.util.List;

public class ReturnFruitsOperation implements StoreOperations {

    @Override
    public void action(List<Fruit> fruitList, String name, LocalDate date, Integer quantity) {
        StoreOperations storeOperation = new SupplyFruitsOperation();
        storeOperation.action(fruitList, name, date, quantity);
    }
}
