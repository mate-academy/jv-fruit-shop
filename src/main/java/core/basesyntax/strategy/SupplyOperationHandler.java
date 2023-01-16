package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class SupplyOperationHandler implements OperationHandler {
    FruitDao dao = new FruitDaoImpl();

    @Override
    public void handle(List<FruitTransaction> balanceList) {
        for (FruitTransaction currentFruitBalanceTransaction : balanceList) {
            List<FruitTransaction> supplyList = dao.getFruitOperationsList("s", currentFruitBalanceTransaction.getFruit());
            for (FruitTransaction tr : supplyList) {
                int amountToAdd = tr.getQuantity();
                int currentAmount = currentFruitBalanceTransaction.getQuantity();
                currentFruitBalanceTransaction.setQuantity(currentAmount + amountToAdd);
            }
        }
    }
}
