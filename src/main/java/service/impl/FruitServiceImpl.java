package service.impl;

import dao.FruitDao;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitService;
import service.ParserService;
import strategy.TransactionStrategy;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;
    private final TransactionStrategy transactionStrategy;
    private final ParserService parserService;

    public FruitServiceImpl(FruitDao fruitDao,
                            TransactionStrategy transactionStrategy, ParserService parserService) {
        this.fruitDao = fruitDao;
        this.transactionStrategy = transactionStrategy;
        this.parserService = parserService;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitList) {
        fruitList.forEach(fruit ->
                transactionStrategy.getOperation(fruit.getOperationType())
                        .handle(fruit));
    }

    @Override
    public List<String> createReport(List<FruitTransaction> fruits) {
        processTransactions(fruits);
        List<String> stringList = fruitDao.getAll().entrySet().stream()
                .map(fruitInfo -> fruitInfo.getKey() + "," + fruitInfo.getValue())
                .collect(Collectors.toList());
        stringList.add(0, formattedHeader(parserService.getHeader()));
        return stringList;
    }

    private String formattedHeader(String header) {
        return Arrays.stream(header.split(","))
                .skip(1)
                .collect(Collectors.joining(","));
    }
}
