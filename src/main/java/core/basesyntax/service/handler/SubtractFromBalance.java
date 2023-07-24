package core.basesyntax.service.handler;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class SubtractFromBalance implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public SubtractFromBalance(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public long updateBalance(Fruit fruit) {
        Optional<Fruit> fruitFromDb = fruitShopDao.get(fruit.getName());
        if (fruitFromDb.isEmpty() || fruitFromDb.get().getAmount() < fruit.getAmount()) {
            throw new RuntimeException("Invalid amount");
        }
        long updatedBalance = fruitFromDb.get().getAmount() - fruit.getAmount();
        fruit.setAmount(updatedBalance);
        fruitShopDao.add(fruit);
        return updatedBalance;
    }
}
