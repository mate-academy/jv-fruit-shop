package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.datemanipulation.FruitTransaction;
import core.basesyntax.model.Fruit;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {

            String fruitName = transactions.get(i).getFruit();

            int quant = transactions.get(i).getQuantity();

            Fruit fruit = fruitDao.get(fruitName);

            operationStrategy.get(transactions.get(i).getOperation()).doOperation(fruit,quant);

        }
    }

}
