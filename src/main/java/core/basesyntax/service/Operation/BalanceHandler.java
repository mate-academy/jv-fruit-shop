package core.basesyntax.service.Operation;
import core.basesyntax.service.ShopServiceStrategy;
import core.basesyntax.dao.StorageDaoImpl;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int amount) {
        StorageDaoImpl.clear();
        StorageDaoImpl.addProduct(ShopServiceStrategy.Operation.BALANCE, amount);
    }
}
