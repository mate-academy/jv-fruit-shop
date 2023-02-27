package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class OperationHandlerOfSupply implements OperationHandler {
    public static final int QUANTITY_MARKER = 0;
    private final FruitDao storageDao;

    public OperationHandlerOfSupply() {
        this.storageDao = new FruitDaoImpl();
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("Fruit transaction can`t be null");
        }
        if (fruitTransaction.getQuantity() < QUANTITY_MARKER) {
            throw new RuntimeException("Supply can`t be negative");
        }

        Fruit fruit = storageDao.get(fruitTransaction.getFruit());
        int fruitAmount = fruit.getQuantity();
        fruit.setQuantity(fruitAmount + fruitTransaction.getQuantity());
    }
}
