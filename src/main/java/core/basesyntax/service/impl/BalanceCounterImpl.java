package core.basesyntax.service.impl;

import core.basesyntax.dao.ActionsDao;
import core.basesyntax.dao.ActionsDaoImpl;
import core.basesyntax.fruit.Fruit;
import core.basesyntax.service.ActionStrategy;
import core.basesyntax.service.BalanceCounter;
import java.util.List;

public class BalanceCounterImpl implements BalanceCounter {
    private ActionsDao actionsDao = new ActionsDaoImpl();

    @Override
    public void calculateBalance(List<Fruit> fruitsMoving, ActionStrategy mapStrategy) {
        int deltaValue;
        for (Fruit fruit : fruitsMoving) {
            deltaValue = mapStrategy.get(fruit.getTypeAction()).getNewValue(fruit.getAmount());
            if (!actionsDao.isPresentFruit(fruit.getName())) {
                actionsDao.add(fruit.getName(), fruit.getAmount());
            }
            actionsDao.update(fruit.getName(), actionsDao.getAmount(fruit.getName()) + deltaValue);
        }
    }
}
