package core.basesyntax.dto.handlers;

import core.basesyntax.dao.DAoService;
import core.basesyntax.models.FruitRecord;

public class PurchaseOperationHandler implements OperationsHandler {
    @Override
    public void apply(DAoService daoService, FruitRecord fruitRecord) {
        fruitRecord.setAmount(fruitRecord.getAmount() * (-1));
        daoService.changeAmountOfFruits(fruitRecord);
    }
}
