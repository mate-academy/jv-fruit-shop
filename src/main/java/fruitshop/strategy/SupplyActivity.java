package fruitshop.strategy;

import fruitshop.database.Storage;
import fruitshop.model.Fruit;
import fruitshop.model.FruitTransaction;

public class SupplyActivity implements TypeOfActivity {
    @Override
    public void realizeType(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getFruit());
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, fruitTransaction.getQuantity());
        } else {
            int oldAmount = Storage.storage.get(fruit);
            Storage.storage.put(fruit, oldAmount + fruitTransaction.getQuantity());
        }
    }
}
