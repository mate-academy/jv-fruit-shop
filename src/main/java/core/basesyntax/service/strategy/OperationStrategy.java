package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.TransferAction;

public interface OperationStrategy {
    void process(FruitDao fruitDao, TransferAction transferAction);
}
