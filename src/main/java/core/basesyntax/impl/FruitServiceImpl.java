package core.basesyntax.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;

import java.io.File;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculateFruit(List<FruitTransaction> fruits) {
        for (FruitTransaction fruitTransaction : fruits) {
            int fruitQuantity = fruitTransaction.getQuantity();
            int operation = operationStrategy.get(fruitTransaction.getOperation()).getOperation(fruitTransaction.getQuantity());
            int resultQ = fruitQuantity + operation != 0 ? fruitQuantity : -fruitQuantity;
            if (Storage.fruits.get(fruitTransaction.getFruit()) != null) {
                Storage.fruits.put(fruitTransaction.getFruit(),
                        Storage.fruits.get(fruitTransaction.getFruit()) + resultQ);
                System.out.println( fruitTransaction.getFruit() + fruitTransaction.getOperation()+Storage.fruits.get(fruitTransaction.getFruit()));
                continue;
            }
            Storage.fruits.put(fruitTransaction.getFruit(), resultQ);

            System.out.println(Storage.fruits.get(fruitTransaction.getFruit()));
        }
        System.out.println(Storage.fruits);
    }
}
