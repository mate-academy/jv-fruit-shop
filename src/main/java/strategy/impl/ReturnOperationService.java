package strategy.impl;

import exception.InsufficientFruitsException;
import strategy.OperationService;
import dao.FruitDao;
import model.Fruit;

public class ReturnOperationService implements OperationService {
    private final FruitDao fruitDao;

    public ReturnOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        if (fruit.getSold() >= quantity) {
            int newQuantity = fruit.getQuantity() + quantity;
            fruit.setQuantity(newQuantity);
            fruit.setSold(fruit.getSold() - quantity);
            fruitDao.update(fruit);
        } else {
            throw new InsufficientFruitsException("Not enough fruits were sold to fulfill the request");
        }
    }
}
