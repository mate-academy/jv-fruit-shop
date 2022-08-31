package service.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ProcessDataService;
import strategy.handler.OperationHandler;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public void processData(List<FruitTransaction> list,
                            Map<FruitTransaction.Operation, OperationHandler> operationsMap) {
        for (FruitTransaction fruitTransaction : list) {
            operationsMap.get(fruitTransaction.getOperation()).apply(fruitTransaction);
        }
    }
}
