package core.basesyntax.dao;

import core.basesyntax.goods.FruitPack;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Box {
    private Map<LocalDate, FruitPack> box;

    public Box() {
       box = new HashMap<>();
    }

    public Box(FruitPack product) {
        box = new HashMap<>();
        this.addProduct(product);
    }

    public Box addProduct(FruitPack product) {
        if (product == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        FruitPack fruitPack = new FruitPack(product);
        LocalDate expDate = product.getExpDate();
        FruitPack.checkExpDate(expDate);
        if (!box.isEmpty()) {
            int newQuantity = fruitPack.getQuantity();
            int prevQuantity = box.get(expDate).getQuantity();
            fruitPack = fruitPack.setQuantity(newQuantity + prevQuantity);
        }
        box.put(expDate, fruitPack);
        return this;
    }

    public FruitPack getProduct(LocalDate expDate) {
        FruitPack.checkExpDate(expDate);
        return box.get(expDate);
    }

    public Set<LocalDate> getExpDates() {
        return box.keySet();
    }

    public boolean removeProduct(LocalDate expDate) {
        FruitPack.checkExpDate(expDate);
        box.remove(expDate);
        return true;
    }

    public void clear() {
        box.clear();
    }

    public int size() {
        return box.size();
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
