package service.impl;

import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.ApplyStrategyService;
import service.FruitShopService;
import storage.Storage;

public class FruitShopServiceImpl implements FruitShopService {
    private ApplyStrategyService applyStrategyService;

    public FruitShopServiceImpl(ApplyStrategyService applyStrategyService) {
        this.applyStrategyService = applyStrategyService;
    }

    @Override
    public void transfer(List<FruitTransaction> fruitRecordList) {
        for (FruitTransaction fruitRecord : fruitRecordList) {
            Operation type = fruitRecord.getOperationType();
            Storage.storage.put(fruitRecord.getFruit(),
                    applyStrategyService.getHandler(type).changeAmount(fruitRecord));
        }
    }
}
