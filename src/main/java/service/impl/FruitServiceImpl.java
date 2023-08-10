package service.impl;

import dao.FruitDao;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitService;
import strategy.TransactionStrategy;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;
    private final TransactionStrategy transactionStrategy;

    public FruitServiceImpl(FruitDao fruitDao, TransactionStrategy transactionStrategy) {
        this.fruitDao = fruitDao;
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public List<String> transaction(List<FruitTransaction> fruitList) {
        fruitList.forEach(fruit ->
                transactionStrategy.getOperation(fruit.getOperationType()).handle(fruit));
        return fruitDao.getAll().entrySet().stream()
                .map(fruitInfo -> fruitInfo.getKey() + "," + fruitInfo.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> createReport(List<String> fruits, String header) {
        String formattedHeader = Arrays.stream(header.split(","))
                .skip(1)
                .collect(Collectors.joining(","));
        fruits.add(0, formattedHeader);
        return fruits;
    }
}
