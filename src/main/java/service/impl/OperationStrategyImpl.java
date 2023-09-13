package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import exception.InvalidDataException;
import model.Fruit;
import service.OperationStrategy;
import service.operationHandler.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private FruitDao fruitDao;

    public OperationStrategyImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    //private FruitDao fruitDao = new FruitDaoImpl();
    @Override
    public Fruit update(Fruit fruit) {
        return switch (fruit.getOperation().trim()) {
            case "b" -> balanceOperation(fruit);
            case "s" -> supplyOperation(fruit);
            case "p" -> purchaseOperation(fruit);
            case "r" -> returnOperation(fruit);
            default -> throw new RuntimeException("Operation type is illegal");
        };
    }

    private Fruit returnOperation(Fruit fruit) {
        fruitDao.get(fruit).setQuantity(fruitDao.get(fruit).getQuantity() + fruit.getQuantity());
        return fruitDao.get(fruit);
    }

    /*private Fruit returnOperation(Fruit fruit) {
        if (fruitDao.check(fruit)) {
            return fruitDao.increaseQuantity(fruit);
        } throw new RuntimeException("There is no fruit with a " + fruit.getName() + " on a balance");
    }*/

    private Fruit purchaseOperation(Fruit fruit) {
        if (fruitDao.get(fruit).getQuantity() < fruit.getQuantity()) {
            throw new InvalidDataException("Storage doesn't have required amount of " + fruit.getName());
        }
        fruitDao.get(fruit).setQuantity(fruitDao.get(fruit).getQuantity() - fruit.getQuantity());
        return fruitDao.get(fruit);
    }

    /*private Fruit purchaseOperation(Fruit fruit) {
        if (fruitDao.check(fruit)) {
            return fruitDao.decreaseQuantity(fruit);
        } throw new RuntimeException("There is no fruit with a " + fruit.getName() + " on a balance");
    }*/

    private Fruit supplyOperation(Fruit fruit) {
        fruitDao.get(fruit).setQuantity(fruitDao.get(fruit).getQuantity() + fruit.getQuantity());
        return fruitDao.get(fruit);
    }

    /*private Fruit supplyOperation(Fruit fruit) {
        if (fruitDao.check(fruit)) {
            return fruitDao.increaseQuantity(fruit);
        } throw new RuntimeException("There is no fruit with a " + fruit.getName() + " on a balance");
    }*/

    private Fruit balanceOperation(Fruit fruit) {
        return fruitDao.add(fruit);
    }

    /*private Fruit balanceOperation(Fruit fruit) {
        if (fruitDao.check(fruit)) {
            return fruitDao.update(fruit);
        } else {
            return fruitDao.add(fruit);
        }
    }*/
}
