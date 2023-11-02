package core.basesyntax.operationshandlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storagedao.StorageDao;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateValueInStorage(FruitTransaction transaction) {
        validAmountOfFruit(transaction);
        Map.Entry<Fruit, Integer> fruitAndAmount = storageDao.get(transaction.getFruitName());
        Integer fruitAmount = fruitAndAmount.getValue();
        Integer fruitAmountFromTransaction = transaction.getQuantity();
        fruitAndAmount.setValue(fruitAmount - fruitAmountFromTransaction);

    }

    private void validAmountOfFruit(FruitTransaction transaction) {
        validAmount(transaction);
        if (!storageDao.isInStorage(transaction.getFruitName())) {
            throw new RuntimeException("There is no such fruit!!!");
        }
        if (storageDao.get(transaction.getFruitName()).getValue() < transaction.getQuantity()) {
            throw new RuntimeException("Amount of " + transaction.getFruitName()
                    + " isn't enough!!!");
        }
    }
}
