package core.basesyntax.procedures.classes;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.procedures.interfaces.Procedure;
import java.util.Map;

public class BalanceProcedure implements Procedure {
    @Override
    public void doProcedure(Fruit fruit, int quantity) {
        Map<Fruit, Integer> fruitMap = Storage.getFruitData();
        if (fruitMap.containsKey(fruit)) {
            throw new RuntimeException(fruit.getFruitName() + " exists in the storage already");
        }
        fruitMap.put(fruit, quantity);
    }
}
