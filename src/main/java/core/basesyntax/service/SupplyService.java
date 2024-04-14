package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;
import java.util.List;

public class SupplyService implements ShopService {
    @Override
    public void operationHandler() {
        List<FruitTransaction> supply = DataBase.fruitDataBase.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.SUPPLY)
                .toList();

        supply.forEach(fruitTransaction ->
                ReportCreator.storageForReport.replace(fruitTransaction.getFruit(),
                        ReportCreator.storageForReport.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity()));
    }
}
