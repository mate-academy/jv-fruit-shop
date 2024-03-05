package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.Fruit;
import model.FruitTransaction;
import service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao fruitDao;

    public FruitTransactionServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void makeOperation(FruitTransaction.Operation operation, String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        int newQuantity = fruit.getQuantity();
        switch (operation) {
            case BALANCE -> fruit.setQuantity(quantity);
            case PURCHASE -> fruit.setQuantity(newQuantity -= quantity);
            case RETURN, SUPPLY -> fruit.setQuantity(newQuantity += quantity);
        }
        fruitDao.update(fruit);
    }
}
