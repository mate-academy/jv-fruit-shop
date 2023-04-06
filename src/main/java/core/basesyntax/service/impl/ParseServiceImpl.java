package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;

public class ParseServiceImpl implements ParseService {
    @Override
    public FruitTransaction fruitTransaction(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] split = line.split(",");
        fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(split[0]));
        fruitTransaction.setFruit(split[1]);
        fruitTransaction.setQuantity(Integer.parseInt(split[2]));
        return fruitTransaction;
    }
}
