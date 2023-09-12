package strategy.impl;

import java.util.Map;
import strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {

    @Override
    public void doTransaction(Map<String, Integer> reportList, String fruit, int value) {
        if (!reportList.containsKey(fruit)) {
            reportList.put(fruit, value);
            return;
        }
        throw new RuntimeException(String.format("%s already in report", fruit));
    }
}
