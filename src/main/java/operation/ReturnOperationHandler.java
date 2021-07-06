package operation;

import service.BalanceService;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void changeBalance(BalanceService balanceService, String item, Integer quantity) {
        balanceService.updateBalance(item, quantity);
    }
}
