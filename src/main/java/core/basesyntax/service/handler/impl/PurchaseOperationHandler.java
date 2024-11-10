package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class PurchaseOperationHandler extends BaseOperationHandler implements OperationHandler {
    private final FruitRepository repository;

    public PurchaseOperationHandler(FruitRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        checkTransaction(transaction);
        if (repository.hasFruit(transaction.getFruit())) {
            repository.remove(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new RuntimeException("Can't return fruits that are/were not in storage");
        }
    }
}
