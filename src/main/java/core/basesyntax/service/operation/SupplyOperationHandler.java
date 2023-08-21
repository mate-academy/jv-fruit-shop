package core.basesyntax.service.operation;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void operationHandler(String fruit, Integer quantity) {
        fruitDao.add(fruit, fruitDao.get(fruit) + quantity);
        System.out.println("Fruit: " + fruit + " SupplyOperationHandler: " + fruitDao.get(fruit));
    }
}
