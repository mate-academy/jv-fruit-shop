package service;

import db.Storage;
import model.FruitRecord;
import model.Operation;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<FruitRecord> transferFruitList) {
        for (FruitRecord fruitRecord : transferFruitList) {
            Operation type = fruitRecord.getTypeOperation();
            Storage.storage.put(fruitRecord.getFruit(),
                    operationStrategy.getHandler(type).changeAmount(fruitRecord));
        }
    }
}
