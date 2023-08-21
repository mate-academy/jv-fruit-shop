package core.basesyntax.service.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operationHandler(String fruit, Integer quantity) {
        fruitDao.add(fruit, quantity);
        System.out.println("Fruit: " + fruit + " BalanceOperationHandler: " + fruitDao.get(fruit));
    }
}
