package strategy;

import java.util.Map;

public interface OperationHandler {
    void doTransaction(Map<String, Integer> reportList, String fruit, int value);
}
