package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruits;
import core.basesyntax.model.Operations;
import core.basesyntax.service.operations.OperationsStrategy;
import java.util.List;
import java.util.Optional;

public class FruitsServiceImpl implements FruitsService {
    private static final int FRUITS_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATIONS_INDEX = 0;
    private static final int DEFAULT_QUANTITY = 0;
    private static final String SEPARATOR = ",";
    private final FruitsDao fruitsDao;
    private final OperationsStrategy operationsStrategy;

    public FruitsServiceImpl(FruitsDao fruitDao, OperationsStrategy strategy) {
        this.fruitsDao = fruitDao;
        operationsStrategy = strategy;
    }

    @Override
    public void createNewFruits(String fruitName, int quantity) {
        Fruits fruits = new Fruits(fruitName, quantity);
        fruitsDao.add(fruits);
    }

    @Override
    public int getOperatedCount(int oldFruitsQuantity, int newFruitsQuantity,
                                Operations operation) {
        return operationsStrategy.get(operation)
                .getOperationsResult(oldFruitsQuantity, newFruitsQuantity);
    }

    @Override
    public void createFruitsFromList(List<String> fruitsDocumentation) {
        for (var record : fruitsDocumentation) {
            String[] splitRecord = record.split(SEPARATOR);

            Operations operation = Operations.getOperations(splitRecord[OPERATIONS_INDEX]);
            String fruitName = splitRecord[FRUITS_INDEX];
            int quantity = Integer.parseInt(splitRecord[QUANTITY_INDEX]);

            Fruits newFruits = new Fruits(fruitName, quantity);
            Optional<Fruits> optionalFruitFromDb = fruitsDao.getFruitsIfPresent(fruitName);

            if (optionalFruitFromDb.isPresent()) {
                newFruits.setQuantity(getOperatedCount(optionalFruitFromDb.get().getQuantity(),
                        newFruits.getQuantity(), operation));
            } else {
                newFruits.setQuantity(
                        getOperatedCount(DEFAULT_QUANTITY, newFruits.getQuantity(), operation));
            }
            fruitsDao.add(newFruits);
        }
    }
}
