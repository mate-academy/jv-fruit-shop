package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;
import java.util.List;

public class PurchaseService implements ShopService {
    @Override
    public void operationWithFruits() {
        List<FruitTransaction> purchase = DataBase.fruitDataBase.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.PURCHASE)
                .toList();

        purchase.forEach(fruitTransaction ->
                ReportCreator.storageForReport.replace(fruitTransaction.getFruit(),
                        ReportCreator.storageForReport.get(fruitTransaction.getFruit())
                            - fruitTransaction.getQuantity()));
    }
}
