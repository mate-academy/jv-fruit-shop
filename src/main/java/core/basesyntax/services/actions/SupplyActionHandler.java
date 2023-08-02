package core.basesyntax.services.actions;

import core.basesyntax.db.Storage;

public class SupplyActionHandler implements ActionHandler {
    @Override
    public boolean actionStore(Storage fruitDB, String nameOfGoods, Integer valueOfTask) {
        validData(fruitDB, nameOfGoods);
        Integer value = fruitDB.getStorageFruits().get(nameOfGoods);
        return fruitDB.add(nameOfGoods, value + valueOfTask);
    }
}
