package shop.strategy;

import shop.dao.FruitDao;
import shop.model.FruitTransaction;

public interface TransactionService {
    FruitDao dao = new FruitDao();

    void process(FruitTransaction transaction);
}
