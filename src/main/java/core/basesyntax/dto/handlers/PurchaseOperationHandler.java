package core.basesyntax.dto.handlers;

import core.basesyntax.dao.FruitDaoService;
import core.basesyntax.models.FruitRecord;

public class PurchaseOperationHandler implements OperationsHandler {
    @Override
    public void apply(FruitDaoService daoService, FruitRecord fruitRecord) {
        fruitRecord.setAmount(fruitRecord.getAmount() * (-1));
        daoService.put(fruitRecord);
    }
}
