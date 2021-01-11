package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int AMOUNT = 2;
    private static final String DELIMITER = ",";
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void doOperation(List<String> informationFromFile) {
        Operation operation = new Operation();
        for (String eachLine : informationFromFile) {
            String[] oneLine = eachLine.split(DELIMITER);
            Fruit fruit = new Fruit(oneLine[FRUIT_NAME]);
            if (addNewFruit(oneLine, fruit)) {
                continue;
            }
            int amountAfterOperation = checkOperation(oneLine, operation);
            if (fruitDao.containsKey(fruit)) {
                fruitDao.update(fruit, amountAfterOperation);
            }
        }
    }

    private boolean addNewFruit(String[] oneLine, Fruit fruit) {
        if (oneLine[OPERATION].toUpperCase().equals(Operation.Type.B.toString())
                && !fruitDao.containsKey(fruit) && Integer.parseInt(oneLine[AMOUNT]) > 0) {
            fruitDao.add(fruit, Integer.parseInt(oneLine[AMOUNT]));
            return true;
        }
        return false;
    }

    private int checkOperation(String[] oneLine, Operation operation) {
        int amountAfterOperation = 0;
        if (operation.checkOperation(Operation.Type.valueOf(oneLine[OPERATION].toUpperCase()))) {
            checkInputData(oneLine, operation);
            amountAfterOperation = operationStrategy.get(operation.getOperation())
                    .getOperation(Integer.parseInt(oneLine[AMOUNT]));
        }
        return amountAfterOperation;
    }

    private void checkInputData(String[] oneLine, Operation operation) {
        if (Integer.parseInt(oneLine[AMOUNT]) < 0) {
            throw new ArithmeticException("Amount cannot be below than zero");
        }
        if (operation.getOperation().equals(Operation.Type.P)
                && Integer.parseInt(oneLine[AMOUNT])
                > fruitDao.getAmount(new Fruit(oneLine[FRUIT_NAME]))) {
            throw new ArithmeticException("Customer cannot buy more fruit than in stock");
        }
    }
}

