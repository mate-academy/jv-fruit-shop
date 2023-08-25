package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitItem;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitItemService;
import core.basesyntax.service.FruitItemServiceImpl;

public class FruitTransactionHandlerBalance implements FruitTransactionHandler {
    private FruitDao fruitDao = new FruitDaoImpl();
    private FruitItemService fruitItemService = new FruitItemServiceImpl();

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (fruitDao.containsName(fruitName)) {
            System.out.println("WARNING, Storage.fruits already contains fruitName: "
                    + fruitName + ". Data about its quantity has been overwritten.");
        }
        FruitItem newFruitItem = fruitItemService.create(fruitName, fruitQuantity);
        fruitDao.put(newFruitItem);
    }
}
