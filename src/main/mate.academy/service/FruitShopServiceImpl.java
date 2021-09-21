package service;

import db.Storage;
import model.Fruit;
import model.FruitRecord;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<FruitRecord> transferFruitList) {
        for (FruitRecord fruitRecord : transferFruitList) {
            String type = fruitRecord.getTypeOperation();
            Storage.storage.put(fruitRecord.getFruit(),
                    operationStrategy.getHandler(type).changeAmount(fruitRecord, Storage.storage));
        }
    }
}