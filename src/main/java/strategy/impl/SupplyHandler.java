package strategy.impl;

import java.util.Map;
import strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {

    @Override
    public void doTransaction(Map<String, Integer> reportList, String fruit, int value) {
        int oldValue = reportList.get(fruit);
        reportList.put(fruit, oldValue + value);
    }
}
