package core.basesyntax.shopimpl.service;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorageService {
    private static final String ILLEGAL_STATE_MESSAGE
            = "Illegal data entry was found while storage initialization"
              + " storage can't contain negative values";
    
    public void apply(Map<Fruit, Integer> storage,
                      List<DataRecord> records) {
        for (AbstractItem fruit : getDistinctItems(records)) {
            storage.put((Fruit) fruit, 0);
        }
        
        for (DataRecord record : records) {
            ShopTransactionsType type = record.getAction();
            switch (type) {
                case SUPPLY:
                    applySupply(storage, record);
                    break;
                case PURCHASE:
                    applyPurchase(storage, record);
                    break;
                case RETURN:
                    applyReturn(storage, record);
                    break;
                default:
                    applyBalance(storage, record);
                    break;
            }
        }
    }
    
    private List<AbstractItem> getDistinctItems(List<DataRecord> records) {
        return records.stream()
                .map(DataRecord::getItem)
                .distinct()
                .collect(Collectors.toList());
    }
    
    private void applyBalance(Map<Fruit, Integer> storage,
                              DataRecord record) {
        Fruit key = (Fruit) record.getItem();
        storage.put(key, record.getAmount());
    }
    
    private void applyPurchase(Map<Fruit, Integer> storage,
                               DataRecord record) {
        Fruit key = (Fruit) record.getItem();
        int updatedValue = storage.get(key) - record.getAmount();
        if (updatedValue < 0) {
            throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
        }
        storage.put(key, storage.get(key) - record.getAmount());
        
    }
    
    private void applySupply(Map<Fruit, Integer> storage,
                             DataRecord record) {
        Fruit key = (Fruit) record.getItem();
        storage.put(key, storage.get(key) + record.getAmount());
    }
    
    private void applyReturn(Map<Fruit, Integer> storage,
                             DataRecord record) {
        applySupply(storage, record);
    }
}
