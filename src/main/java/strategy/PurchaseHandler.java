package strategy;

import db.Storage;
import model.Fruit;
import model.Transaction;

public class PurchaseHandler implements OptionHandler {
    private static final int DEFAULT_QUALITY = 0;

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruitName());
        int quality = transaction.getQuality();
        int oldQuality = Storage.getFruits().containsKey(fruit)
                ? Storage.getFruits().get(fruit) : DEFAULT_QUALITY;
        if (oldQuality < quality) {
            throw new RuntimeException("We don't have that much fruit");
        }
        quality = oldQuality - quality;
        Storage.getFruits().put(fruit, quality);
    }
}
