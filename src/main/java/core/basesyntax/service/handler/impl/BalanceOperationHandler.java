package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitRepository fruitRepository;

    public BalanceOperationHandler(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitRepository.add(transaction.getFruit(), transaction.getQuantity());
    }
}
