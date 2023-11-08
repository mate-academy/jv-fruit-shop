package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationManagerImpl implements OperationManager {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;
    private final Map<Operation, OperationHandler> operationMap;

    public OperationManagerImpl() {
        this.operationMap = new HashMap<>();

        operationMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
    }

    @Override
    public void addInfoToDB(List<String> stringList, FruitDB fruitDB) {
        for (String str : stringList) {
            String[] infoStr = str.split(SEPARATOR);
            if (!Operation.validAbbreviation(infoStr[OPERATION])) {
                continue;
            }
            Operation operation = Operation.getOperation(infoStr[OPERATION]);
            String name = infoStr[NAME];
            Integer quantity = Integer.parseInt(infoStr[QUANTITY]);

            OperationHandler fruitOperation = operationMap.get(operation);

            if (fruitOperation != null) {
                fruitOperation.performOperation(fruitDB, name, quantity);
            }
        }
    }
}
