package strategy.impl;

import strategy.OperationService;
import dao.FruitDao;
import model.Fruit;

public class ReturnOperationService implements OperationService {
    private FruitDao fruitDao;

    public ReturnOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
