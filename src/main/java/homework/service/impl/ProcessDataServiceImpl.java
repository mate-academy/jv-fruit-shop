package homework.service.impl;

import homework.model.FruitTransaction;
import homework.service.ProcessDataService;
import homework.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public void processData(List<FruitTransaction> list,
                            Map<FruitTransaction.Operation, OperationHandler> operationsMap) {
        for (FruitTransaction fruitTransaction : list) {
            operationsMap.get(fruitTransaction.getOperation()).apply(fruitTransaction);
        }
    }
}
