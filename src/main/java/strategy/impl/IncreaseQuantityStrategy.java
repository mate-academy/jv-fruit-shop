package strategy.impl;

import model.FruitTransaction;
import dao.FruitDao;

public record SupplyOperation(FruitDao fruitDao) implements OperationsHandler {
    private static final String SUPPLY_CANT_BE_ZERO = "Supply can't be zero";

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() == 0) {
            throw new RuntimeException(SUPPLY_CANT_BE_ZERO);
        }
        fruitDao.putToStorage(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}