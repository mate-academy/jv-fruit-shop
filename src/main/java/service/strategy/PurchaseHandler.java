package service.strategy;

import dao.FruitDao;
import model.Fruit;
import model.Transaction;

public class PurchaseHandler implements OptionHandler {
    private static final int DEFAULT_QUALITY = 0;
    private final FruitDao dao;

    public PurchaseHandler(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruitName());
        int quality = transaction.getQuality();
        int oldQuality = dao.getQuantity(fruit).orElse(DEFAULT_QUALITY);
        if (oldQuality < quality) {
            throw new RuntimeException("We don't have that much fruit");
        }
        quality = oldQuality - quality;
        dao.add(fruit,quality);
    }
}
