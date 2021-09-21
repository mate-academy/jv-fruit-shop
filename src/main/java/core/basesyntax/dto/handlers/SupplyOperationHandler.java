package core.basesyntax.dto.handlers;

import core.basesyntax.dao.DAoService;
import core.basesyntax.models.FruitRecord;

public class SupplyOperationHandler implements OperationsHandler {
    @Override
    public void apply(DAoService dAoService, FruitRecord fruitRecord) {
        dAoService.changeAmountOfFruits(fruitRecord);
    }
}
