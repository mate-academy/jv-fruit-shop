package fruit.shop.strategy;

import java.util.List;

public interface OperationHandler {
    int FIRST_INDEX = 1;
    int SECOND_INDEX = 2;

    boolean calculateOperation(List<String> data);

    static boolean checkResult(Integer result) {
        if (result < 0) {
            throw new RuntimeException("Quantity is < 0 " + result);
        }
        return false;
    }
}
