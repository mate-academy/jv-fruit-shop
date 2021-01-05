package core.basesyntax.procedures.classes;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.procedures.interfaces.Procedure;
import java.util.Map;

public class PurchaseProcedure implements Procedure {
    @Override
    public void doProcedure(Fruit fruit, int quantity) {
        Map<Fruit, Integer> fruitMap = Storage.getFruitData();
        if (!fruitMap.containsKey(fruit)) {
            throw new RuntimeException("There are no "
                    + fruit.getFruitName() + " in the storage");
        }
        if (fruitMap.get(fruit) - quantity < 0) {
            throw new RuntimeException("There are not enough "
                    + fruit.getFruitName() + " in the storage");
        }
        fruitMap.put(fruit, fruitMap.get(fruit) - quantity);
    }
}
