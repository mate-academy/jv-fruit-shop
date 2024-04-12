package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class BalanceService implements ShopService {
    @Override
    public void operationWithFruits() {
        Storage.storageForReport.putAll(Storage.storageFromInputFile.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.BALANCE)
                .collect(Collectors.toMap(FruitTransaction::getFruit,
                        FruitTransaction::getQuantity)));
    }
}
