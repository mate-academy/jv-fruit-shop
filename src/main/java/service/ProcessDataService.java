package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.handler.OperationHandler;

public interface ProcessDataService {
    void processData(List<FruitTransaction> list,
                     Map<FruitTransaction.Operation, OperationHandler> operationsMap);
}
