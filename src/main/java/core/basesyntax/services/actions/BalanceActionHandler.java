package core.basesyntax.services.actions;

import java.util.Map;

public class BalanceActionHandler implements ActionHandler {
    @Override
    public Map.Entry<String, Integer> actionStore(Map<String, Integer> copyDataFrmDB,
                                                  String nameOfGoods, Integer valueOfTask) {
        return Map.entry(nameOfGoods, valueOfTask);
    }
}
