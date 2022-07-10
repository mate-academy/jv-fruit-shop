package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.quantity.CounterHandler;
import core.basesyntax.strategy.CounterStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final FruitTransactionDao fruitTransactionDao;
    private final CounterStrategy counterStrategy;

    public ShopServiceImpl(FruitTransactionDao fruitTransactionDao,
                           CounterStrategy counterStrategy) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.counterStrategy = counterStrategy;
    }
    
    @Override
    public void processTheData(List<String[]> fileInfo) {
        fileInfo.stream()
                .skip(1)
                .forEach(strings -> {
                    String[] splitTransaction = strings[0].split(";");
                    FruitTransaction transaction = new FruitTransaction();
                    FruitTransaction.Operation operation =
                            Arrays.stream(FruitTransaction.Operation.values())
                                .filter(e -> e.getOperation().equals(splitTransaction[TYPE_INDEX]))
                                .findFirst()
                                .get();
                    transaction.setOperation(operation);
                    transaction.setFruitName(splitTransaction[FRUIT_INDEX]);
                    transaction.setQuantity(Integer.parseInt(splitTransaction[QUANTITY_INDEX]));
                    fruitTransactionDao.add(transaction);
                });
    }

    @Override
    public List<Fruit> getStatistic() {
        List<FruitTransaction> fruitTransactions = fruitTransactionDao.getAll();
        List<Fruit> fruits = identifyFruits();
        for (Fruit fruit : fruits) {
            fruitTransactions.stream()
                    .filter(transaction -> transaction.getFruitName().equals(fruit.getFruitName()))
                    .forEach(transaction -> {
                        CounterHandler counterHandler =
                                counterStrategy.get(transaction.getOperation());
                        counterHandler.calculateQuantity(fruit, transaction);
                    });
        }
        return fruits;
    }

    @Override
    public String makeReport() {
        List<Fruit> fruits = getStatistic();
        StringBuilder builder = new StringBuilder();
        fruits.forEach(fruit -> builder.append(fruit.getFruitName())
                .append(",").append(fruit.getQuantity()).append(System.lineSeparator()));
        return builder.toString();
    }

    public List<Fruit> identifyFruits() {
        List<FruitTransaction> fruitTransactions = fruitTransactionDao.getAll();
        return fruitTransactions.stream()
                .map(FruitTransaction::getFruitName)
                .distinct()
                .map(Fruit::new)
                .collect(Collectors.toList());
    }
}
