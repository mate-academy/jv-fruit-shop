package core.basesyntax.services.actions;

import core.basesyntax.db.Storage;

public class BalanceActionHandler implements ActionHandler {
    private static Storage fruitDB;

    public BalanceActionHandler(Storage fruitDB) {
        this.fruitDB = fruitDB;
    }

    @Override
    public boolean actionStore(String nameOfGoods, Integer valueOfTask) {
        return fruitDB.add(nameOfGoods, valueOfTask);
    }
}
