package core.basesyntax.service.impl;

import core.basesyntax.dao.ActionsDao;
import core.basesyntax.dao.ActionsDaoImpl;
import core.basesyntax.modelfruit.ModelFruit;
import core.basesyntax.service.ActionStrategy;
import core.basesyntax.service.Balance;
import java.util.List;

public class BalancePerDay implements Balance {
    private ActionsDao actionsDao = new ActionsDaoImpl();

    @Override
    public void calculateBalance(List<ModelFruit> fruitsMoving, ActionStrategy mapStrategy) {
        int deltaValue;
        for (ModelFruit fruit : fruitsMoving) {
            deltaValue = mapStrategy.get(fruit.getTypeAction()).getNewValue(fruit.getAmount());
            if (!actionsDao.isPresentFruit(fruit.getName())) {
                actionsDao.add(fruit.getName(), fruit.getAmount());
            }
            actionsDao.update(fruit.getName(), actionsDao.getAmount(fruit.getName()) + deltaValue);
        }
    }
}
