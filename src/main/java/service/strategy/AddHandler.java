package service.strategy;

import dao.DaoOption;
import dao.DaoOptionImpl;
import model.Fruit;
import model.Transaction;

public class AddHandler implements OptionHandler {
    private static final int DEFAULT_QUALITY = 0;

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruitName());
        DaoOption dao = new DaoOptionImpl();
        int quality = transaction.getQuality();
        int oldQuality = dao.getFruit(fruit).orElse(DEFAULT_QUALITY);
        quality += oldQuality;
        dao.add(fruit,quality);
    }
}
