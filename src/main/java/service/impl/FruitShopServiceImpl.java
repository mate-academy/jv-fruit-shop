package service.impl;

import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.FruitShopService;
import service.OperationService;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationService operationService;

    public FruitShopServiceImpl(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public void process(List<FruitTransaction> fruitRecordList) {
        for (FruitTransaction fruitRecord : fruitRecordList) {
            Operation type = fruitRecord.getOperationType();
            operationService.getHandler(type).handle(fruitRecord);
        }
    }
}
