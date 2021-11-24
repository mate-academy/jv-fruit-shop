package service.strategy;

import dao.FruitDao;
import model.Fruit;
import model.Transaction;

public class AddHandler implements OptionHandler {
    private static final int DEFAULT_QUALITY = 0;
    private final FruitDao dao;

    public AddHandler(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruitName());
        int quantity = transaction.getQuality();
        int oldQuantity = dao.getQuantity(fruit).orElse(DEFAULT_QUALITY);
        quantity += oldQuantity;
        dao.add(fruit,quantity);
    }
}
