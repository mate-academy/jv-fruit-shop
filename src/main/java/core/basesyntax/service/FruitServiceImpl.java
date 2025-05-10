package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;
import java.util.Optional;

public class FruitServiceImpl implements FruitService {

    private static final int QUANTITY_INDEX = 2;
    private static final int FRUIT_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int DEFAULT_QUANTITY = 0;
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(FruitDao fruitDao, OperationStrategy strategy) {
        this.fruitDao = fruitDao;
        operationStrategy = strategy;
    }

    @Override
    public void createNewFruit(String fruitName, int quantity) {
        Fruit fruit = new Fruit(fruitName, quantity);
        fruitDao.add(fruit);
    }

    @Override
    public int getOperatedCount(int oldFruitQuantity, int newFruitQuantity, Operation operation) {
        return operationStrategy.get(operation)
                .getOperationResult(oldFruitQuantity, newFruitQuantity);
    }

    @Override
    public void createFruitsFromList(List<String> fruitRecords) {
        for (var record : fruitRecords) {
            String[] splitRecord = record.split(SEPARATOR);

            Operation operation = Operation.getOperation(splitRecord[OPERATION_INDEX]);
            String fruitName = splitRecord[FRUIT_INDEX];
            int quantity = Integer.parseInt(splitRecord[QUANTITY_INDEX]);

            Fruit newFruit = new Fruit(fruitName, quantity);
            Optional<Fruit> optionalFruitFromDb = fruitDao.getFruitIfPresent(fruitName);

            if (optionalFruitFromDb.isPresent()) {
                newFruit.setQuantity(getOperatedCount(optionalFruitFromDb.get().getQuantity(),
                        newFruit.getQuantity(), operation));
            } else {
                newFruit.setQuantity(
                        getOperatedCount(DEFAULT_QUANTITY, newFruit.getQuantity(), operation));
            }
            fruitDao.add(newFruit);
        }
    }
}
