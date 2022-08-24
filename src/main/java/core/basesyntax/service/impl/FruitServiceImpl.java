package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl() {
    }

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void createFruit(List<FruitTransaction> fruitTransactionList) {
        List<String> fruitNames = fruitTransactionList.stream()
                .map(FruitTransaction::getFruitName)
                .distinct()
                .collect(Collectors.toList());
        for (String fruitName : fruitNames) {
            Fruit fruit = new Fruit();
            fruit.setFruitName(fruitName);
            fruit.setQuantity(0);
            fruitDao.add(fruit);
        }

    }
}
