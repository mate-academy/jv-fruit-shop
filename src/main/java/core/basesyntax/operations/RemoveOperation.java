package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.interfaces.Operation;
import core.basesyntax.model.Fruit;
import java.util.List;

public class RemoveOperation implements Operation {
    private FruitDao fruitDao = new FruitDaoImpl();

    public List<Fruit> apply(Transaction fruitsFromFile) {
        fruitDao.getAll().sort((o1, o2) -> {
            if (o2.getExpirationDate().isEqual(o1.getExpirationDate())) {
                return 0;
            }
            return (o2.getExpirationDate().isBefore(o1.getExpirationDate())) ? 1 : -1;
        });
        int amountBuying = fruitsFromFile.getAmount();
        for (int i = 0; i < fruitDao.getAll().size(); i++) {
            Fruit fruit = fruitDao.getAll().get(i);
            if (fruitsFromFile.getTypeOfFruit().equals(fruit.getTypeOfFruit())
                    && (fruitsFromFile.getExpirationDate()
                    .isEqual(fruitDao.getAll().get(i).getExpirationDate())
                    || fruitsFromFile.getExpirationDate()
                    .isBefore(fruitDao.getAll().get(i).getExpirationDate()))
                    && (amountBuying != 0)) {
                fruitDao.getAll().remove(fruit);
                amountBuying--;
                i--;
            }
        }
        if (amountBuying != 0) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        return fruitDao.getAll();
    }
}
