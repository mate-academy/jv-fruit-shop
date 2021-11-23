package strategy;

import db.Storage;
import model.Fruit;
import model.Transaction;

public class AddHandler implements OptionHandler {
    private static final int DEFAULT_QUALITY = 0;

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruitName());
        int quality = transaction.getQuality();
        int oldQuality = Storage.getFruits().containsKey(fruit)
                ? Storage.getFruits().get(fruit) : DEFAULT_QUALITY;
        quality += oldQuality;
        Storage.getFruits().put(fruit, quality);
    }
}
