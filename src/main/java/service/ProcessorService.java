package service;

import model.FruitTransaction;
import service.Handler.OperationHandler;

import java.util.List;
import java.util.Map;

public interface ProcessorService {
    Map<String, Integer> processOnData(List<FruitTransaction> transactions,
                                       Map<FruitTransaction.Operation, OperationHandler> operation);
}
