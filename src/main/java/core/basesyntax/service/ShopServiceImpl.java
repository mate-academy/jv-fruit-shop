package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.datemanipulation.FruitTransaction;
import core.basesyntax.model.Fruit;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;
    private FruitService fruitService;

    public ShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
        fruitService = new FruitServiceImpl(this.fruitDao);
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            String fruitName = transactions.get(i).getFruit();
            int quant = transactions.get(i).getQuantity();
            Fruit fruit;
            if (fruitDao.isPresent(fruitName)) {
                fruit = fruitDao.get(fruitName);
            } else {
                fruitService.createNewFruit(fruitName, quant);
                continue;
            }
            int countFrut = fruit.getAmount();

            int koef = operationStrategy.get(transactions.get(i).getOperation()).getOperation();
            if (koef != 0) {
                countFrut += (koef) * transactions.get(i).getQuantity();
                fruit.setAmount(countFrut);
            }

        }
    }

}
