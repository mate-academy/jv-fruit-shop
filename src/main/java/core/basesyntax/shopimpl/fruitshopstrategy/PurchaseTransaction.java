package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractTransaction;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.entity.IllegalPurchaseAmountException;
import core.basesyntax.shopimpl.service.Validator;

public class PurchaseTransaction extends AbstractTransaction<DataRecord, Fruit> {
    public PurchaseTransaction(AbstractStorage<DataRecord, Fruit> storage,
                               ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        try {
            Validator.transactionValidator(item, amount, getStorage());
            int update = getStorage().get(item) - amount;
            getStorage().put((Fruit) item, update);
            getShopDao().addTransaction(new DataRecord(ShopTransactionsTypes.PURCHASE,
                    item,
                    amount));
            getShopDao().updateDatabase();
        } catch (IllegalPurchaseAmountException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong while validating transaction");
        }
    }
}
