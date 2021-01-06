package core.basesyntax.shopimpl.storage;

import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.service.StorageService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopStorage extends AbstractStorage<DataRecord, Fruit> {
    public FruitShopStorage(ShopDao<DataRecord> shopDao) {
        super(shopDao);
    }
    
    @Override
    protected Map<Fruit, Integer> initStorage(ShopDao<DataRecord> shopDao) {
        Map<Fruit, Integer> storage = new HashMap<>();
        List<DataRecord> dataRecords = shopDao.getTransactionHistory();
    
        new StorageService().apply(storage,dataRecords);
        
        return storage;
    }
}
