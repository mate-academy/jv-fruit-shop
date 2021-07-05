package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.TransferAction;
import core.basesyntax.model.FruitImpl;

public class SetQuantityStrategy implements OperationStrategy {

    @Override
    public void process(FruitDao fruitDao, TransferAction transferAction) {
        fruitDao.put(new FruitImpl(transferAction.getName()), transferAction.getQuantity());
    }
}
