package core.basesyntax.Service.TransactionOperations;

import core.basesyntax.Dao.FruitDao;
import core.basesyntax.Model.FruitTransaction;
import java.util.List;

public class FruitTransactionReportMakerImpl implements FruitTransactionReportMaker {
    @Override
    public List<FruitTransaction> makeReport(FruitDao dao) {
        List<FruitTransaction> balanceList = dao.getFirst("b");
        for (FruitTransaction currentFruitTransaction : balanceList) {
            List<FruitTransaction> supplyList = dao.get("s", currentFruitTransaction.getFruit());
            List<FruitTransaction> returnList = dao.get("r", currentFruitTransaction.getFruit());
            List<FruitTransaction> purchaseList = dao.get("p", currentFruitTransaction.getFruit());

            for (FruitTransaction tr : supplyList) {
                int amountToAdd = tr.getQuantity();
                int currentAmount = currentFruitTransaction.getQuantity();
                currentFruitTransaction.setQuantity(currentAmount + amountToAdd);
            }
            for (FruitTransaction tr : returnList) {
                int amountToReturn = tr.getQuantity();
                int currentAmount = currentFruitTransaction.getQuantity();
                currentFruitTransaction.setQuantity(currentAmount + amountToReturn);
            }
            for (FruitTransaction tr : purchaseList) {
                int amountToRemove = tr.getQuantity();
                int currentAmount = currentFruitTransaction.getQuantity();
                currentFruitTransaction.setQuantity(currentAmount - amountToRemove);
            }
        }
        return balanceList;
    }
}
