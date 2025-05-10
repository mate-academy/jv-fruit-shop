package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.exception.InvalidInputException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitRepository fruitRepository;

    public ReturnOperationHandler(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (fruitRepository.hasFruit(transaction.getFruit())) {
            fruitRepository.add(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new InvalidInputException("Can't return fruits that are/were not in storage");
        }
    }
}
