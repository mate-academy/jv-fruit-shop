package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import org.junit.jupiter.api.Test;

class FruitServiceImplTest {
    FruitDao fruitDao = new FruitDaoImpl();
    FruitService fruitService = new FruitServiceImpl(fruitDao);

    @Test
    void inputData_Ok() {
        fruitService.addNewFruit("apple", 100);
        assertEquals(1, Storage.fruits.size());
        fruitService.addNewFruit("banana", 4);
        assertEquals(2, Storage.fruits.size());
        Storage.fruits.clear();
    }
}
