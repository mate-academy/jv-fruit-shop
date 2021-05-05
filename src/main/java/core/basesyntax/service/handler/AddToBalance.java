package core.basesyntax.service.handler;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class AddToBalance implements OperationHandler {
    private final FruitShopDao fruitShopDao;

    public AddToBalance(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public long updateBalance(Fruit fruit) {
        if (fruit.getAmount() < 0) {
            throw new RuntimeException("Invalid amount");
        }
        Optional<Fruit> fruitFromDb = fruitShopDao.get(fruit.getName());
        if (fruitFromDb.isPresent()) {
            long updatedBalance = fruitFromDb.get().getAmount() + fruit.getAmount();
            fruit.setAmount(updatedBalance);
            fruitShopDao.add(fruit);
            return updatedBalance;
        }
        fruitShopDao.add(fruit);
        return fruit.getAmount();
    }
}
