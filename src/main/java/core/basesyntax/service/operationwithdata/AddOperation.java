package core.basesyntax.service.operationwithdata;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitmodel.Fruit;
import java.util.Optional;

public class AddOperation implements FruitOperationService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public int apply(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getFruitName());
        Optional<Integer> currentQuantityFruit =
                Optional.ofNullable(fruitDao.get(fruit));
        if (currentQuantityFruit.isPresent()) {
            int newBalance = currentQuantityFruit.get() + fruitDto.getCountFruit();
            fruitDao.save(fruit, newBalance);
            return newBalance;
        }
        fruitDao.save(fruit, fruitDto.getCountFruit());
        return fruitDto.getCountFruit();
    }
}

