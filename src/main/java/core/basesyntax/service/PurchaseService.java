package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;
import java.util.List;

public class PurchaseService implements ShopService {
    @Override
    public void operationWithFruits() {
        List<FruitTransaction> purchase = Storage.storageFromInputFile.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.PURCHASE)
                .toList();

        purchase.forEach(fruitTransaction ->
                Storage.storageForReport.replace(fruitTransaction.getFruit(),
                    Storage.storageForReport.get(fruitTransaction.getFruit())
                            - fruitTransaction.getQuantity()));
    }
}
