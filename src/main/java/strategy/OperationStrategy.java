package strategy;

import db.GenericDao;
import java.util.Map;

public class OperationTypes {
    private GenericDao dao;
    private OperationStrategy defaultStrategy = new AdditionalOperationHandler(dao);
    private Map<String, OperationStrategy> operationsMap;

    public OperationTypes(GenericDao dao) {
        this.dao = dao;
        operationsMap = Map.of(
                "b", new AdditionalOperationHandler(dao),
                "s", new AdditionalOperationHandler(dao),
                "p", new PurchaseOperationHandler(dao),
                "r", new AdditionalOperationHandler(dao));
    }

    public OperationStrategy getOperationStrategy(String operation) {
        if (isOperationExist(operation)) {
            return operationsMap.get(operation);
        }
        throw new RuntimeException("There is no operation like this: " + operation);
    }

    public boolean isOperationExist(String operation) {
        return operationsMap.containsKey(operation);
    }
}
