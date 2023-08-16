package service.impl;

import dao.Fruit;
import dao.FruitDao;
import java.util.List;
import model.TransactionDto;
import service.FruitService;
import strategy.Operation;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitsDao;
    private OperationStrategy strategy;

    public FruitServiceImpl(FruitDao fruitsDao, OperationStrategy activitiesStrategy) {
        this.fruitsDao = fruitsDao;
        this.strategy = activitiesStrategy;
    }

    public List<Fruit> changeBalance(List<TransactionDto> transactions) {
        for (TransactionDto transactionDto: transactions) {
            OperationHandler activitiesService = strategy.get(Operation
                    .getActivityType(transactionDto.getActivity()));
            activitiesService.apply(transactionDto.getFruitName(),
                    transactionDto.getQuantity());
        }
        return fruitsDao.getAll();
    }

    public void executeTransactions(List<Transaction> transactions) {

    }

    public class Transaction {
    }
}
