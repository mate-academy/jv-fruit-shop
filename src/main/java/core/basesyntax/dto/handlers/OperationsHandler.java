package core.basesyntax.dto.handlers;

import core.basesyntax.dao.FruitDaoService;
import core.basesyntax.models.FruitRecord;

public interface OperationsHandler {
    void apply(FruitDaoService daoService, FruitRecord fruitRecord);
}
