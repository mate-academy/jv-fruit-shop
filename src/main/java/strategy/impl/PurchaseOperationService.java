package strategy.impl;

import dao.FruitDao;
import exception.OutOfStockException;
import model.Fruit;
import strategy.OperationService;

public class PurchaseOperationService implements OperationService {
    private final FruitDao fruitDao;

    public PurchaseOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        int newQuantity = fruit.getQuantity() - quantity;
        if (newQuantity >= 0) {
            fruit.setQuantity(newQuantity);
            fruit.setSold(fruit.getSold() + quantity);
            fruitDao.update(fruit);
        } else {
            throw new OutOfStockException("You cannot sell more than you have in the store");
        }
    }
}
