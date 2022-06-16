package core.basesyntax.service;

import core.basesyntax.dao.ActionsDao;
import core.basesyntax.dao.ActionsDaoImpl;
import core.basesyntax.model.Model;
import core.basesyntax.service.actiontype.ActionStrategyB;
import core.basesyntax.service.actiontype.ActionStrategyP;
import core.basesyntax.service.actiontype.ActionStrategyR;
import core.basesyntax.service.actiontype.ActionStrategyS;
import core.basesyntax.service.actiontype.ActionType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBalancePerDay implements GetBalance {
    private ActionsDao actionsDao = new ActionsDaoImpl();
    private ActionStrategy actionStrategy;
    private Map<String, Integer> fruitAmount = new HashMap<>();
    private Map<String, ActionType> mapStrategy = new HashMap<>();

    @Override
    public void getBalance() {
        mapStrategy.put("b", new ActionStrategyB());
        mapStrategy.put("p", new ActionStrategyP());
        mapStrategy.put("s", new ActionStrategyS());
        mapStrategy.put("r", new ActionStrategyR());
        List<Model> fruitsList = actionsDao.getAllActions();
        actionStrategy = new ActionStrategyImpl(mapStrategy);
        int deltaValue = 0;
        for (Model model : fruitsList) {
            deltaValue = actionStrategy.get(model.getTypeAction()).getNewValue(model.getAmount());
            fruitAmount.put(model.getName(),
                    fruitAmount.containsKey(model.getName())
                            ? fruitAmount.get(model.getName()) + deltaValue : model.getAmount());
        }
        if (actionsDao.isDoneReport(fruitAmount)) {
            System.out.println("Report was done!");
        }
    }
}
