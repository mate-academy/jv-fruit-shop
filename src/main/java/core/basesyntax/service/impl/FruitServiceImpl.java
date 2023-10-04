package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void recordFruits(List<FruitTransaction> fruitTransaction) {
        List<FruitTransaction> firstAmountFruits = fruitTransaction.stream()
                .filter(item -> item.getOperation() == FruitTransaction.Operation.BALANCE)
                .distinct()
                .collect(Collectors.toList());
        firstAmountFruits.forEach(fruitTransactionItem -> {
            Fruit fruit = new Fruit();
            fruit.setFruit(fruitTransactionItem.getFruit());
            fruit.setQuantity(fruitTransactionItem.getQuantity());
            fruitDao.add(fruit);
        });
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitDao.getAll();
    }
}
