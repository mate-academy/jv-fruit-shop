package core.basesyntax.service.operation;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void operationHandler(String fruit, Integer quantity) {
        fruitDao.add(fruit, fruitDao.get(fruit) + quantity);
        System.out.println("Fruit: " + fruit + " ReturnOperationHandler: " + fruitDao.get(fruit));
    }
}
