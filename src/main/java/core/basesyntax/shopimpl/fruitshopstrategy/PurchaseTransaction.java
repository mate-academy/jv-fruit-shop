package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.AbstractTransaction;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.service.Validator;
import core.basesyntax.shopimpl.storage.FruitShopStorage;

public class PurchaseTransaction extends AbstractTransaction<DataRecord, Fruit> {
    public PurchaseTransaction(FruitShopStorage storage, FruitShopDao shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        try {
            Validator.transactionValidator(item, amount, getStorage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
