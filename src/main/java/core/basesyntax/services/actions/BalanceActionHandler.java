package core.basesyntax.services.actions;

import core.basesyntax.db.Storage;

public class BalanceActionHandler implements ActionHandler {
    @Override
    public boolean actionStore(Storage fruitDB, String nameOfGoods, Integer valueOfTask) {
        return fruitDB.add(nameOfGoods, valueOfTask);
    }
}
