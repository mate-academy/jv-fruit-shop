package core.basesyntax.services.actions;

import java.util.Map;

public class ReturnActionHandler implements ActionHandler {
    @Override
    public Map.Entry<String, Integer> actionStore(Map<String, Integer> copyDataFrmDB,
                                                  String nameOfGoods, Integer valueOfTask) {
        validData(copyDataFrmDB, nameOfGoods);
        Integer value = copyDataFrmDB.get(nameOfGoods);
        return Map.entry(nameOfGoods, value + valueOfTask);
    }
}
