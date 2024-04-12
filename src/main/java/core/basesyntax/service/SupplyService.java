package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;
import java.util.List;

public class SupplyService implements ShopService {
    @Override
    public void operationWithFruits() {
        List<FruitTransaction> supply = Storage.storageFromInputFile.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.SUPPLY)
                .toList();

        supply.forEach(fruitTransaction ->
                Storage.storageForReport.replace(fruitTransaction.getFruit(),
                Storage.storageForReport.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity()));
    }
}
