package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractTransaction;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.entity.IllegalPurchaseAmountException;
import core.basesyntax.shopimpl.service.Validator;

public class PurchaseTransaction extends AbstractTransaction<DataRecord, Fruit> {
    public PurchaseTransaction(AbstractStorage<DataRecord, Fruit> storage, ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        try {
            Validator.transactionValidator(item, amount, getStorage());
        } catch (IllegalPurchaseAmountException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Program runtime failed while purchase execution", e);
        }
    }
}
