package core.basesyntax.dao;

import core.basesyntax.goods.FruitPack;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Box {
    private static final LocalDate TODAY = LocalDate.now();
    private Map<LocalDate, FruitPack> box;

    public Box() {
       box = new HashMap<>();
    }

    public boolean addProduct(FruitPack product) {
        LocalDate expDate = product.getExpDate();
        FruitPack.checkExpDate(expDate);
        box.put(expDate, product);
        return true;
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

    @Override
    public String toString() {
        return box.entrySet().toString();
    }

    public void put(LocalDate expDate, FruitPack product) {
        FruitPack.checkExpDate(expDate);
        box.put(expDate, product);
    }
}
