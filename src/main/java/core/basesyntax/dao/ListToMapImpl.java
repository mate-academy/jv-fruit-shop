package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;
import core.basesyntax.db.Operation;
import java.util.List;
import java.util.Map;

public class ListToMapImpl implements ListToMap {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;
    private final FruitDB fruitDB = new FruitDB();

    @Override
    public Map<String, Integer> listToMap(List<String> stringList) {
        for (String str : stringList) {
            String[] infoStr = str.split(SEPARATOR);
            if (Operation.validAbbreviation(infoStr[OPERATION])) {
                continue;
            }

            Operation operation = Operation.fromAbbreviation(infoStr[OPERATION]);
            String name = infoStr[NAME];
            Integer quantity = Integer.parseInt(infoStr[QUANTITY]);

            switch (operation) {
                case BALANCE:
                case SUPPLY:
                case RETURN:
                    fruitDB.add(name, quantity);
                    break;
                case PURCHASE:
                    fruitDB.remove(name, quantity);
                    break;
                default:
                    break;
            }
        }

        return fruitDB.getAllFruits();
    }
}
