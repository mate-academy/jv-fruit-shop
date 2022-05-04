package service.impl;

import dao.DatabaseDao;
import dao.DatabaseDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;
import strategy.StrategyService;

public class ParseServiceImpl implements ParseService {
    private final DatabaseDao dao = new DatabaseDaoImpl();

    @Override
    public void parse(List<FruitTransaction> fruitTransactions,
                                      StrategyService strategyService) {
        for (FruitTransaction transaction : fruitTransactions) {
            int storeQuantity = dao.getAllFruits().get(transaction.getFruit()) == null ? 0
                    : dao.getAllFruits().get(transaction.getFruit());
            int transactionOperation = strategyService.get(transaction.getOperation())
                    .operationHandler(transaction, storeQuantity);
            dao.addFruit(transaction.getFruit(), transactionOperation);
        }
    }
}
