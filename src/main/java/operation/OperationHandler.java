package operation;

import service.BalanceService;

public interface OperationHandler {
    void changeBalance(BalanceService fruitBalanceService, String fruit, Integer quantity);
}
