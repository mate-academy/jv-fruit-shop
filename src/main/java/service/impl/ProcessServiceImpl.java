package service.impl;

import java.util.List;
import java.util.Map;
import model.ActivityType;
import model.FruitTransaction;
import service.ProcessService;
import strategy.OperationsHandler;

public class ProcessServiceImpl implements ProcessService {
    private Map<ActivityType, OperationsHandler> processedStoreHandler;

    public ProcessServiceImpl(Map<ActivityType, OperationsHandler> storeHandler) {
        this.processedStoreHandler = storeHandler;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            processedStoreHandler.get(fruitTransaction.getActivityType())
                    .useOperation(fruitTransaction);
        }
    }
}
