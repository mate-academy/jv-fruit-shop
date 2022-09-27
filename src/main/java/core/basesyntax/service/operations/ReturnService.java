package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnService implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        SupplyService supplyService = new SupplyService(fruitDao);
        supplyService.handle(fruitTransaction);
    }
}
