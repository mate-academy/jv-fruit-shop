package core.basesyntax.service.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public class ActivitiesHandlerReturn implements ActivitiesHandler {

    @Override
    public void handleActivity(StorageService storageService, FruitTransaction fruitTransaction) {
        storageService.add(new Fruit(fruitTransaction.getFruit()), fruitTransaction.getQuantity());
    }
}
