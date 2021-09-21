package core.basesyntax.dto.handlers;

import core.basesyntax.dao.DAoService;
import core.basesyntax.models.FruitRecord;

public class PurchaseOperationHandler implements OperationsHandler {
    @Override
    public void apply(DAoService dAoService, FruitRecord fruitRecord) {
        fruitRecord.setAmount(fruitRecord.getAmount() * (-1));
        dAoService.changeAmountOfFruits(fruitRecord);
    }
}
