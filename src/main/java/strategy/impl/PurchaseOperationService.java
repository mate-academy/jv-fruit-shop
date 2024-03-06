package strategy.impl;

import strategy.OperationService;
import dao.FruitDao;
import model.Fruit;

public class PurchaseOperationService implements OperationService {
    private FruitDao fruitDao;

    public PurchaseOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        int newQuantity = fruit.getQuantity() - quantity;
        if (newQuantity >= 0) {
            fruit.setQuantity(newQuantity);
            fruitDao.update(fruit);
        }
    }
}
