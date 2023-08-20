package core.basesyntax.services.actions;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.ValidationDataException;

public class PurchaseActionHandler implements ActionHandler {
    private static Storage fruitDB;

    public PurchaseActionHandler(Storage fruitDB) {
        this.fruitDB = fruitDB;
    }

    @Override
    public boolean executeAction(String nameOfGoods, Integer valueOfTask) {
        validateData(fruitDB, nameOfGoods);
        Integer value = fruitDB.getStorageFruits().get(nameOfGoods);
        if (value < valueOfTask) {
            throw new ValidationDataException("Client can't buy " + valueOfTask
                    + " " + nameOfGoods + " only " + value + " available");
        }
        return fruitDB.add(nameOfGoods, value - valueOfTask);
    }
}
