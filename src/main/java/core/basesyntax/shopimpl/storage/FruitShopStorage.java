package core.basesyntax.shopimpl.storage;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitShopStorage extends AbstractStorage<DataRecord, Fruit> {
    public FruitShopStorage(ShopDao<DataRecord> shopDao) {
        super(shopDao);
    }
    
    @Override
    protected Map<Fruit, Integer> initStorage(ShopDao<DataRecord> shopDao) {
        Map<Fruit, Integer> storage = new HashMap<>();
        
        List<AbstractItem> fruits = shopDao.getTransactionHistory().stream()
                .map(DataRecord::getItem)
                .distinct()
                .collect(Collectors.toList());
        
        for (AbstractItem fruit : fruits) {
            storage.put((Fruit) fruit, 0);
        }
        
        for (DataRecord record : shopDao.getTransactionHistory()) {
            if (record.getAction() == ShopTransactionsTypes.PURCHASE) {
                Fruit key = (Fruit) record.getItem();
                int updatedValue = storage.get(key) - record.getAmount();
                if (updatedValue < 0) {
                    throw new IllegalStateException("Illegal data entry was found"
                                                    + " while storage initialization"
                                                    + " storage can't contain negative values");
                }
                storage.put(key, storage.get(key) - record.getAmount());
                continue;
            }
            if (record.getAction() == ShopTransactionsTypes.BALANCE) {
                Fruit key = (Fruit) record.getItem();
                storage.put(key, record.getAmount());
                continue;
            }
            Fruit key = (Fruit) record.getItem();
            storage.put(key, storage.get(key) + record.getAmount());
        }
        
        return storage;
    }
}
