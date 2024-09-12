package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.handler.OperationHandler;

public interface ProcessorService {
    void processOnData(List<FruitTransaction> transactions,
                                       Map<FruitTransaction.Operation, OperationHandler> operation);
}
