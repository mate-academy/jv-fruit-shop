package service.strategy.strategyimpl;

import database.Storage;
import model.FruitRecord;

public class PurchaseStrategy implements TypeService {
    @Override
    public void calculation(FruitRecord record) {
        Integer currentQuantity = Storage.storage.get(record.getFruit());
        int purchaseQuantity = record.getQuantity();
        if (currentQuantity == null && currentQuantity < 0) {
            throw new IllegalArgumentException("Invalid quantity of for purchase.");
        }
        int newQuantity = currentQuantity - purchaseQuantity;
        Storage.storage.put(record.getFruit(), newQuantity);
    }
}
