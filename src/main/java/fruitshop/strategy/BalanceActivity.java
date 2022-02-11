package fruitshop.strategy;

import fruitshop.database.Storage;
import fruitshop.model.Fruit;
import fruitshop.model.FruitTransaction;

public class BalanceActivity implements TypeOfActivity {
    @Override
    public void realizeType(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getFruit());
        Storage.storage.put(fruit, fruitTransaction.getQuantity());
    }
}
