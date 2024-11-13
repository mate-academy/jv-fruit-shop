package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitRepository repository;

    public SupplyOperationHandler(FruitRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        repository.add(transaction.getFruit(), transaction.getQuantity());
    }
}
