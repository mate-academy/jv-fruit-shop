package core.basesyntax.service.impl;

import core.basesyntax.dao.ActionsDao;
import core.basesyntax.dao.ActionsDaoImpl;
import core.basesyntax.model.Model;
import core.basesyntax.service.ActionStrategy;
import core.basesyntax.service.GetBalance;
import java.util.List;

public class GetBalancePerDay implements GetBalance {
    private ActionsDao actionsDao = new ActionsDaoImpl();

    @Override
    public void calcBalance(List<Model> fruitsMoving, ActionStrategy mapStrategy) {
        int deltaValue;
        for (Model fruit : fruitsMoving) {
            deltaValue = mapStrategy.get(fruit.getTypeAction()).getNewValue(fruit.getAmount());
            if (!actionsDao.isPresentFruit(fruit.getName())) {
                actionsDao.add(fruit.getName(), fruit.getAmount());
            }
            actionsDao.update(fruit.getName(), actionsDao.getAmount(fruit.getName()) + deltaValue);
        }
    }
}
