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
        int quality = transaction.getQuality();
        int oldQuality = dao.getQuantity(fruit).orElse(DEFAULT_QUALITY);
        quality += oldQuality;
        dao.add(fruit,quality);
    }
}
