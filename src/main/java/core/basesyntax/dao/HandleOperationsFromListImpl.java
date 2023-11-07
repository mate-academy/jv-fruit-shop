package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;
import java.util.List;
import java.util.Map;

public class HandleOperationsFromListImpl implements HandleOperationsFromList {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;
    private final FruitDB fruitDB = new FruitDB();

    @Override
    public Map<String, Integer> getMapReport(List<String> stringList,
                                             Map<Operation, FruitOperation> operationMap) {
        for (String str : stringList) {
            String[] infoStr = str.split(SEPARATOR);
            if (!Operation.validAbbreviation(infoStr[OPERATION])) {
                continue;
            }

            Operation operation = Operation.getOperation(infoStr[OPERATION]);
            String name = infoStr[NAME];
            Integer quantity = Integer.parseInt(infoStr[QUANTITY]);

            FruitOperation fruitOperation = operationMap.get(operation);

            if (fruitOperation != null) {
                fruitOperation.performOperation(fruitDB, name, quantity);
            }
        }

        return fruitDB.getAllFruits();
    }
}
