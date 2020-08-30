package core.basesyntax.dao;

import core.basesyntax.goods.FruitPack;
import java.time.LocalDate;
import java.util.HashMap;

public class FruitStorage {
    private HashMap<String, Box> storage;

    public FruitStorage() {
        storage = new HashMap<>();
    }

    public boolean addProduct(FruitPack product) {
        FruitPack.isPresent(product);
        final String type = product.getType();
        final LocalDate expDate = product.getExpDate();
        FruitPack.checkExpDate(expDate);
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
        typeCheck(type);
        return storage.containsKey(type);
    }

    public Box getBox(String type) {
        typeCheck(type);
        if (!storage.containsKey(type)) {
            throw new IllegalArgumentException("Invalid input arguments");
        }
        return storage.get(type);
    }

    public void clearStorage() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    private void typeCheck(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Invalid input arguments");
        }
    }
}
