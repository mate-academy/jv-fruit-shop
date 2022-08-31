package service.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ProcessDataService;
import strategy.handler.OperationHandler;

public class ProcessDataServiceImpl implements ProcessDataService {
    private Map<FruitTransaction.Operation, OperationHandler> operations;

    public ProcessDataServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public void processData(List<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            operations.get(fruitTransaction.getOperation()).apply(fruitTransaction);
        }
    }
}
