package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;
import java.util.stream.Collectors;

public class BalanceService implements ShopService {
    @Override
    public void operationHandler() {
        ReportCreator.storageForReport.putAll(DataBase.fruitDataBase.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.BALANCE)
                .collect(Collectors.toMap(FruitTransaction::getFruit,
                        FruitTransaction::getQuantity)));
    }
}
