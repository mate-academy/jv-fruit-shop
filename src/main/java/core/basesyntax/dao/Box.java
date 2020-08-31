package core.basesyntax.dao;

import core.basesyntax.goods.FruitPack;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Box {
    private final Map<LocalDate, FruitPack> box;

    public Box() {
        box = new HashMap<>();
    }

    public Box(FruitPack product) {
        box = new HashMap<>();
        putProduct(product);
    }

    public Box putProduct(FruitPack product) {
        FruitPack.isPresent(product);
        LocalDate expDate = product.getExpDate();
        FruitPack.checkExpDate(expDate);
        if (!box.isEmpty() && box.containsKey(expDate)) {
            int newQuantity = product.getQuantity();
            int prevQuantity = box.get(expDate).getQuantity();
            product = product.setQuantity(newQuantity + prevQuantity);
        }
        box.put(expDate, product);
        return this;
    }

    public Box takeProduct(FruitPack product) {
        FruitPack.isPresent(product);
        LocalDate expDate = product.getExpDate();
        FruitPack.checkExpDate(expDate);
        if (!box.isEmpty() && box.containsKey(expDate)) {
            int takingQuantity = product.getQuantity();
            int existingQuantity = box.get(expDate).getQuantity();
            if (takingQuantity > existingQuantity) {
                throw new IllegalArgumentException("Lack of products");
            } else if (existingQuantity > takingQuantity) {
                product = product.setQuantity(existingQuantity - takingQuantity);
                box.put(expDate, product);
            } else {
                box.remove(expDate);
            }
        }
        return this;
    }

    public FruitPack getProduct(LocalDate expDate) {
        FruitPack.checkExpDate(expDate);
        return box.get(expDate);
    }

    public void clear() {
        box.clear();
    }

    public int size() {
        return box.size();
    }

    public boolean isEmpty() {
        return box.isEmpty();
    }

    @Override
    public String toString() {
        return box.entrySet().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Box that = (Box) o;
        return Objects.equals(box, that.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(box);
    }
}
