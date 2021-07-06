package operation;

import service.BalanceService;

public class BalanceOperationHandler implements OperationHandler {
    public void changeBalance(BalanceService balanceService, String item, Integer quantity) {
        balanceService.updateBalance(item, quantity);
    }
}
