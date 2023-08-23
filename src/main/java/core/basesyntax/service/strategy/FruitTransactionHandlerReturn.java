package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitItem;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitItemService;

public class FruitTransactionHandlerReturn implements FruitTransactionHandler {

    @Override
    public void execute(FruitTransaction fruitTransaction,
                        FruitDao fruitDao,
                        FruitItemService fruitItemService) {
        String fruitName = fruitTransaction.getFruitName();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (!fruitDao.containsName(fruitName)) {
            throw new RuntimeException("Storage.fruits don't contains fruitName: "
                    + fruitName + " for Handle Return.");
        }
        int fruitOldQuantity = fruitDao.getByName(fruitName).getQuantity();
        int fruitNewQuantity = fruitOldQuantity + fruitQuantity;
        FruitItem newFruitItem = fruitItemService.create(fruitName, fruitNewQuantity);
        fruitDao.put(newFruitItem);
    }
}
