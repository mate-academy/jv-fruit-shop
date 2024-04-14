package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.DataBase;
import java.util.List;

public class ReturnService implements ShopService {
    @Override
    public void operationHandler() {
        List<FruitTransaction> returnFruits = DataBase.fruitDataBase.stream()
                .filter(s -> s.getOperation() == FruitTransaction.Operation.RETURN)
                .toList();

        returnFruits.forEach(fruitTransaction ->
                ReportCreator.storageForReport.replace(fruitTransaction.getFruit(),
                        ReportCreator.storageForReport.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity()));
    }
}
