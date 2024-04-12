package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;
import java.util.List;

public class ReturnService implements ShopService {
    @Override
    public void operationWithFruits() {
        List<FruitTransaction> returnFruits = Storage.storageFromInputFile.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.RETURN)
                .toList();

        returnFruits.forEach(fruitTransaction ->
                Storage.storageForReport.replace(fruitTransaction.getFruit(),
                Storage.storageForReport.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity()));
    }
}
