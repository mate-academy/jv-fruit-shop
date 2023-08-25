package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitItem;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitItemService;
import core.basesyntax.service.FruitItemServiceImpl;

public class FruitTransactionHandlerReturn implements FruitTransactionHandler {
    private FruitDao fruitDao = new FruitDaoImpl();
    private FruitItemService fruitItemService = new FruitItemServiceImpl();

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int fruitQuantity = fruitTransaction.getQuantity();
        int fruitOldQuantity = 0;
        if (fruitDao.containsName(fruitName)) {
            fruitOldQuantity = fruitDao.getByName(fruitName).getQuantity();
        }
        int fruitNewQuantity = fruitOldQuantity + fruitQuantity;
        FruitItem newFruitItem = fruitItemService.create(fruitName, fruitNewQuantity);
        fruitDao.put(newFruitItem);
    }
}
