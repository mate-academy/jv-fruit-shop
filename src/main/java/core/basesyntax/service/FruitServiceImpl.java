package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.service.strategy.OperationsStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int FRUITS_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATIONS_INDEX = 0;
    private static final int DEFAULT_QUANTITY = 0;
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;
    private final OperationsStrategy operationsStrategy;

    public FruitServiceImpl(FruitDao fruitDao, OperationsStrategy strategy) {
        this.fruitDao = fruitDao;
        operationsStrategy = strategy;
    }

    @Override
    public void addFruit(String fruitName, int quantity) {
        Fruit fruit = new Fruit(fruitName, quantity);
        fruitDao.add(fruit);
    }

    @Override
    public int performOperation(int oldFruitsQuantity, int newFruitsQuantity,
                                Operations operation) {
        return operationsStrategy.get(operation)
                .applyOperation(oldFruitsQuantity, newFruitsQuantity);
    }

    @Override
    public void addFruitFromList(List<String> fruitsDocumentation) {
        for (var record : fruitsDocumentation) {
            String[] splitRecord = record.split(SEPARATOR);

            Operations operation = Operations.getOperations(splitRecord[OPERATIONS_INDEX]);
            String fruitName = splitRecord[FRUITS_INDEX];
            int quantity = Integer.parseInt(splitRecord[QUANTITY_INDEX]);

            Fruit newFruit = new Fruit(fruitName, quantity);
            int updatedQuantity = fruitDao.getFruitIfPresent(fruitName)
                    .map(fruit -> performOperation(fruit.getQuantity(), quantity, operation))
                    .orElseGet(() -> performOperation(DEFAULT_QUANTITY, quantity, operation));
            newFruit.setQuantity(updatedQuantity);
            fruitDao.add(newFruit);
        }
    }
}
