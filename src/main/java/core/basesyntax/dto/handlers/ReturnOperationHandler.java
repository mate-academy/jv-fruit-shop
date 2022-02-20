package core.basesyntax.dto.handlers;

import core.basesyntax.dao.FruitDaoService;
import core.basesyntax.models.FruitRecord;

public class ReturnOperationHandler implements OperationsHandler {
    @Override
    public void apply(FruitDaoService daoService, FruitRecord fruitRecord) {
        daoService.put(fruitRecord);
    }
}
