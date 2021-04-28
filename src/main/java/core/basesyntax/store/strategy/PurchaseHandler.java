package core.basesyntax.store.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.validator.quantity.QuantityValidator;
import core.basesyntax.validator.quantity.QuantityValidatorImpl;

public class PurchaseHandler implements TypeHandler {
    private final FruitDao fruitDao;
    private final QuantityValidator quantityValidator;

    public PurchaseHandler() {
        fruitDao = new FruitDaoImpl();
        quantityValidator = new QuantityValidatorImpl();
    }

    @Override
    public void makeOperation(String fruitName, long quantity, int lineNumber) {
        long fruitBalance = fruitDao.getBalance(fruitName);
        quantityValidator.isQuantityCorrectForPurcase(quantity,
                fruitBalance, lineNumber);
        fruitDao.update(fruitName, -quantity);
    }
}
