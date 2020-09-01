package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.interfaces.Operation;
import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RemoveFruit implements Operation {

    public List<Fruit> apply(Transaction fruitsFromFile)
            throws NotEnoughFruitsException {
        List<Fruit> fruitsAfterRemove = new ArrayList<>();
        FruitDao fruitDao = new FruitDaoImpl();
        int amountBuying = fruitsFromFile.getAmount();
        if (amountBuying > fruitDao.getAll().size()) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        for (int i = 0; i < fruitDao.getAll().size(); i++) {
            LocalDate dateOfAvailable = LocalDate.parse(fruitDao.getAll()
                    .get(i).getExpirationDate());
            LocalDate dateOfBuying = LocalDate.parse(fruitsFromFile
                    .getExpirationDate());
            if (fruitsFromFile.getTypeOfFruit().equals(fruitDao.getAll().get(i).getTypeOfFruit())
                    && (dateOfBuying.isEqual(dateOfAvailable)
                    || dateOfBuying.isBefore(dateOfAvailable))
                    && amountBuying != 0) {
                amountBuying--;
            } else {
                fruitsAfterRemove.add(fruitDao.getAll().get(i));
            }
        }
        if (amountBuying != 0) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        fruitDao.getAll().clear();
        for (Fruit f : fruitsAfterRemove) {
            fruitDao.add(f);
        }
        return fruitDao.getAll();
    }
}
