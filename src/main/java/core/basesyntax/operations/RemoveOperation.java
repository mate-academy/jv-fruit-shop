package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.interfaces.Operation;
import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.List;

public class RemoveOperation implements Operation {
    private FruitDao fruitDao = new FruitDaoImpl();

    public List<Fruit> apply(Transaction fruitsFromFile) {
        int amountBuying = fruitsFromFile.getAmount();
        if (amountBuying > fruitDao.getAll().stream()
                .filter(fruit -> fruit.getTypeOfFruit().equals(fruitsFromFile.getTypeOfFruit()))
                .count()) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        for (int i = 0; i < fruitDao.getAll().size(); i++) {
            Fruit fruit = fruitDao.getAll().get(i);
            LocalDate dateOfAvailable = LocalDate.parse(fruitDao.getAll()
                    .get(i).getExpirationDate());
            LocalDate dateOfBuying = LocalDate.parse(fruitsFromFile
                    .getExpirationDate());
            if (fruitsFromFile.getTypeOfFruit().equals(fruit.getTypeOfFruit())
                    && (dateOfBuying.isEqual(dateOfAvailable)
                    || dateOfBuying.isBefore(dateOfAvailable))
                    && amountBuying != 0) {
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
