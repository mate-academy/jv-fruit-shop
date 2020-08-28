package core.basesyntax.dao;

import core.basesyntax.goods.Product;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Box {
    private static final LocalDate TODAY = LocalDate.now();
    private Map<LocalDate, Product> box;

    public Box() {
       box = new HashMap<>();
    }

    public boolean addProduct(Product product) {
        LocalDate expDate = product.getExpDate();
        dateCheck(expDate);
        box.put(expDate, product);
        return true;
    }

    public Product getProduct(LocalDate expDate) {
        return box.get(expDate);
    }

    private void dateCheck(LocalDate expDate) {
        if (!expDate.isAfter(TODAY)) {
            throw new DateTimeException("The product is terminated");
        }
    }

    public Set<LocalDate> getExpDates() {
        return box.keySet();
    }

    public boolean removeProduct(LocalDate expDate) {
        box.remove(expDate);
        return true;
    }

    @Override
    public String toString() {
        return box.entrySet().toString();
    }

    public void put(LocalDate expDate, Product product) {
        box.put(expDate, product);
    }
}
