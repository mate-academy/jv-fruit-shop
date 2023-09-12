package strategy.impl;

import strategy.OperationHandler;
import java.util.Map;

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
