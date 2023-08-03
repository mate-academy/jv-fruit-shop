package core.basesyntax.services.actions;

import core.basesyntax.db.Storage;

public class PurchaseActionHandler implements ActionHandler {
    private static Storage fruitDB;

    public PurchaseActionHandler(Storage fruitDB) {
        this.fruitDB = fruitDB;
    }

    @Override
    public boolean actionStore(String nameOfGoods, Integer valueOfTask) {
        validData(fruitDB, nameOfGoods);
        Integer value = fruitDB.getStorageFruits().get(nameOfGoods);
        return fruitDB.add(nameOfGoods, value - valueOfTask);
    }
}
