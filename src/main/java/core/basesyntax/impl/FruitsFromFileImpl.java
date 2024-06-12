package core.basesyntax.impl;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitsFromFile;
import core.basesyntax.db.FruitShopDao;

import java.util.List;
import java.util.stream.Collectors;

public class FruitsFromFileImpl implements FruitsFromFile {
    private FruitShopDao fruitShopDao;

    public FruitsFromFileImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public List<String> getFruits(List<FruitTransaction> fruitTransactions) {
        List<String> fruits = fruitTransactions.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .collect(Collectors.toList());
        for (String fruit : fruits){
            fruitShopDao.putOnlyFruits(fruit);
        }
        return fruits;
    }
}
