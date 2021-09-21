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
    public Map<Fruit, Integer> transfer(List<FruitRecord> transferFruitList,
                                        OperationStrategy operationStrategy) {
        Storage storage = new Storage();
        Map<Fruit, Integer> fruitStorage = storage.getStorage();
        for (FruitRecord fruitRecord : transferFruitList) {
            String type = fruitRecord.getTypeOperation();
            fruitStorage.put(fruitRecord.getFruitName(),
                    operationStrategy.get(type).changeAmount(fruitRecord, fruitStorage));

        }
        return fruitStorage;
    }
}