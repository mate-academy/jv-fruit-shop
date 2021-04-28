package core.basesyntax.store.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.validator.quantity.QuantityValidator;
import core.basesyntax.validator.quantity.QuantityValidatorImpl;

public class PurchaseHandler implements TypeHandler {
    private final FruitDao fruitDao;
    private final QuantityValidator quantityValidator;

    public PurchaseHandler(FruitDao fruitDao,
                           QuantityValidator quantityValidator) {
        this.fruitDao = fruitDao;
        this.quantityValidator = quantityValidator;
    }

    @Override
    public void makeOperation(String fruitName, long quantity) {
        long fruitBalance = fruitDao.getBalance(fruitName);
        quantityValidator.isQuantityCorrectForPurchase(quantity,
                fruitBalance);
        fruitDao.update(fruitName, -quantity);
    }
}
