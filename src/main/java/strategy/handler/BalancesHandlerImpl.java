package strategy.handler;

import dao.WokWithStorageImpl;
import dao.WorkWithStorageDB;
import model.FruitTransaction;

public class BalancesHandlerImpl implements Handler {
    private WorkWithStorageDB storageService = new WokWithStorageImpl();

    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() <= 0) {
            throw new RuntimeException("Can't work with this quantity "
                    + fruitTransaction.getQuantity());
        }
        if (storageService
                .getFromStorage(fruitTransaction.getFruit()) == null) {
            storageService
                    .addInStorage(fruitTransaction.getFruit(),
                            fruitTransaction.getQuantity());
        } else {
            Integer oldQuantity = storageService.getFromStorage(fruitTransaction.getFruit());
            storageService
                    .addInStorage(fruitTransaction.getFruit(),
                            fruitTransaction.getQuantity() + oldQuantity);
        }
    }
}
