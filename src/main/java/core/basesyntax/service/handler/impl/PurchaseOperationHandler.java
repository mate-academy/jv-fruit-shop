package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.exception.InvalidInputException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitRepository repository;

    public PurchaseOperationHandler(FruitRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (repository.hasFruit(transaction.getFruit())) {
            repository.remove(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new InvalidInputException("There are no "
                    + transaction.getFruit()
                    + " in storage");
        }
    }
}
