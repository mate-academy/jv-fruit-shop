package service;

import model.FruitTransaction;
import service.operation.OperationsHandler;

public record FruitServiceImpl(
        Map<FruitTransaction.Operation, OperationsHandler> handlers) implements FruitService {

    @Override
    public OperationsHandler getHandler(FruitTransaction fruitTransaction) {
        return handlers.get(fruitTransaction.getOperation());
    }
}
