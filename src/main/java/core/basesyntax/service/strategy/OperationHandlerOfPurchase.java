package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;

public class OperationHandlerOfPurchase implements OperationHandler {
    private final Validator validator;
    private final FruitDao storageDao;

    public OperationHandlerOfPurchase() {
        this.storageDao = new FruitDaoImpl();
        this.validator = new ValidatorImpl();
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {
        validator.validateFruitTransaction(fruitTransaction);

        Fruit fruit = storageDao.get(fruitTransaction.getFruit());
        int fruitAmount = fruit.getQuantity();
        if (fruitTransaction.getQuantity() > fruitAmount) {
            throw new RuntimeException("Purchase can`t exceed than previous quantity");
        }
        fruit.setQuantity(fruitAmount - fruitTransaction.getQuantity());
    }
}
