package core.basesyntax.service.separator;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.entity.FruitTransaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SeparationFruitsInImpl implements SeparationFruits {
    private final FruitsDao fruitsStorageDao;

    public SeparationFruitsInImpl(FruitsDao fruitsStorageDao) {
        this.fruitsStorageDao = fruitsStorageDao;
    }

    public List<FruitTransaction> separationFruits(List<String> str,
                                                   String fruits,
                                                   boolean useDataBase) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String d : str) {
            String[] split = d.split(",");
            if (split[1].trim().equalsIgnoreCase(fruits.trim())) {
                final String activity = split[0];
                final String fruit = split[1];
                final BigDecimal quantity = BigDecimal.valueOf(Long.parseLong(split[2]));
                FruitTransaction fruitTransaction = new FruitTransaction();
                fruitTransaction.setActivity(activity.trim());
                fruitTransaction.setFruit(fruit.trim());
                fruitTransaction.setQuantity(quantity);
                if (useDataBase) {
                    fruitsStorageDao.addListFruitsStorage(fruitTransaction);
                }
                fruitTransactionList.add(fruitTransaction);
            }
        }
        return fruitTransactionList;
    }
}
