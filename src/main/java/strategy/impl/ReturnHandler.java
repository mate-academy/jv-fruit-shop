package strategy.impl;

import strategy.OperationHandler;
import java.util.Map;

public class ReturnHandler implements OperationHandler {

    @Override
    public void doTransaction(Map<String, Integer> reportList, String fruit, int value) {
        int oldValue = reportList.get(fruit);
        reportList.put(fruit, oldValue + value);
    }
}
