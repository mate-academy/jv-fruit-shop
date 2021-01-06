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
            int amountAfterOperation = checkOperation(oneLine, operation);
            if (fruitDao.containsKey(new Fruit(oneLine[FRUIT_NAME]))) {
                fruitDao.update(new Fruit(oneLine[FRUIT_NAME]), amountAfterOperation);
            }
        }
    }

    private int checkOperation(String[] oneLine, Operation operation) {
        int amountAfterOperation = 0;
        if (isValidOperation(oneLine[OPERATION])) {
            operation.setOperation(Operation.Type.valueOf(oneLine[OPERATION].toUpperCase()));
        } else {
            return 0;
        }
        if (fruitDao.containsKey(new Fruit(oneLine[FRUIT_NAME]))) {
            checkInputData(oneLine, operation);
            amountAfterOperation = operationStrategy.get(operation.getOperation())
                    .getOperation(Integer.parseInt(oneLine[AMOUNT]));
        }
        return amountAfterOperation;
    }

    private boolean isValidOperation(String operation) {
        operation = operation.toUpperCase();
        return operation.equals(Operation.Type.S.toString())
                || operation.equals(Operation.Type.P.toString())
                || operation.equals(Operation.Type.R.toString());
    }

    private void checkInputData(String[] oneLine, Operation operation) {
        if (Integer.parseInt(oneLine[AMOUNT]) < 0) {
            throw new ArithmeticException("Amount cannot be below than zero");
        }
        if (operation.getOperation().equals(Operation.Type.P)
                && Integer.parseInt(oneLine[AMOUNT])
                > fruitDao.getAmount(oneLine[FRUIT_NAME])) {
            throw new ArithmeticException("Customer cannot buy more fruit than in stock");
        }
    }
}

