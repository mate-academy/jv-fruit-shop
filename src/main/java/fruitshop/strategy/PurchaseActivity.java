package fruitshop.strategy;

import fruitshop.database.Storage;
import fruitshop.model.Fruit;
import fruitshop.model.FruitTransaction;

public class PurchaseActivity implements TypeOfActivity {
    @Override
    public void realizeType(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getFruit());
        int currentAmount = Storage.storage.get(fruit);
        Storage.storage.put(fruit,currentAmount - fruitTransaction.getQuantity());
    }
}
