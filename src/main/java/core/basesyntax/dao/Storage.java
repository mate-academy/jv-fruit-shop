package core.basesyntax.dao;

import core.basesyntax.goods.Product;
import java.time.LocalDate;
import java.util.HashMap;

public class Storage {
    private HashMap<String, Box> storage;

    public Storage() {
        storage = new HashMap<>();
    }

    public boolean add(Product product) {
        final String type = product.getType();
        final LocalDate expDate = product.getExpDate();
        Box box = new Box();

        if (!storage.isEmpty()) {
            box = storage.get(type);
            if (box != null) {
                int newQuantity = product.getQuantity();
                int prevQuantity = box.getProduct(expDate).getQuantity();
                product.setQuantity(newQuantity + prevQuantity);
            } else {
                box = new Box();
            }
        }

        box.addProduct(product);
        storage.put(type, box);
        return true;
    }

    public boolean contains(String type) {
        return storage.containsKey(type);
    }

    public Box getBox(String type) {
        return storage.get(type);
    }
}
