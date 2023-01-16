package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao dao = new FruitDaoImpl();

    @Override
    public void handle(List<FruitTransaction> balanceList) {
        for (FruitTransaction currentFruitBalanceTransaction : balanceList) {
            List<FruitTransaction> purchaseList = dao.getFruitOperationsList("p",
                    currentFruitBalanceTransaction.getFruit());
            for (FruitTransaction tr : purchaseList) {
                int amountToRemove = tr.getQuantity();
                int currentAmount = currentFruitBalanceTransaction.getQuantity();
                currentFruitBalanceTransaction.setQuantity(currentAmount - amountToRemove);
            }
        }
    }
}
