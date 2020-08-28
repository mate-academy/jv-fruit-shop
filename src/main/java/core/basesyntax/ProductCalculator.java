package core.basesyntax;

import dto.AbstractOrder;
import dto.BuyerOrder;
import dto.RefunderOrder;
import dto.SupplierOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCalculator {

    public static final Map<String, List<DateAndQuantity>> STORAGE = new HashMap<>();

    private List<DateAndQuantity> getProdInStorage(AbstractOrder order) {
        return STORAGE.get(order.getProductName());
    }

    public void productToStorage(SupplierOrder order) {
        DateAndQuantity dateAndAmount = new DateAndQuantity(order.getDate(), order.getQuantity());
        List<DateAndQuantity> specificFruitList = new ArrayList<>();
        specificFruitList.add(dateAndAmount);
        int counter = 0;
        if (!STORAGE.containsKey(order.getProductName())) {
            STORAGE.put(order.getProductName(), specificFruitList);
            return;
        }
        if (getProdInStorage(order).contains(dateAndAmount)) {
            for (int i = 0; i < getProdInStorage(order).size(); i++) {
                if (getProdInStorage(order).get(i).getDate().isEqual(dateAndAmount.getDate())) {
                    getProdInStorage(order).get(i)
                            .setQuantity(getProdInStorage(order).get(i).getQuantity()
                                    + order.getQuantity());
                }
            }
        } else {
            while (getProdInStorage(order).get(counter).getDate()
                    .isBefore(dateAndAmount.getDate())) {
                counter++;
            }
            getProdInStorage(order).add(counter, dateAndAmount);
        }
    }

    public void productToStorage(BuyerOrder order) {
        int fruitsToSell = 0;
        int counter = 0;
        if (!STORAGE.containsKey(order.getProductName())) {
            throw new RuntimeException("We do not have this product!");
        }
        for (int i = 0; i < getProdInStorage(order).size(); i++) {
            if (order.getDate().isBefore(getProdInStorage(order).get(i).getDate())) {
                fruitsToSell = fruitsToSell + getProdInStorage(order).get(i).getQuantity();
            }
        }
        if (fruitsToSell < order.getQuantity()) {
            throw new RuntimeException("Not Enough Products!");
        } else {
            while (order.getQuantity() > 0) {
                if (getProdInStorage(order).get(counter).getQuantity() > order.getQuantity()) {
                    getProdInStorage(order).get(counter)
                            .setQuantity(getProdInStorage(order).get(counter).getQuantity()
                                    - order.getQuantity());
                    order.setQuantity(0);
                } else {
                    order.setQuantity(order.getQuantity()
                            - getProdInStorage(order).get(counter).getQuantity());
                    getProdInStorage(order).get(counter).setQuantity(0);
                }
                counter++;
            }
        }
    }

    public void productToStorage(RefunderOrder order) {
        DateAndQuantity dateAndAmount = new DateAndQuantity(order.getDate(), order.getQuantity());
        List<DateAndQuantity> specificFruitList = new ArrayList<>();
        specificFruitList.add(dateAndAmount);

        if (!STORAGE.containsKey(order.getProductName())) {
            STORAGE.put(order.getProductName(), specificFruitList);
            return;
        }
        if (!getProdInStorage(order).contains(dateAndAmount)) {
            getProdInStorage(order).add(dateAndAmount);
            return;
        }
        for (int i = 0; i < getProdInStorage(order).size(); i++) {
            if (getProdInStorage(order).get(i).getDate().isEqual(dateAndAmount.getDate())) {
                getProdInStorage(order).get(i)
                        .setQuantity(getProdInStorage(order).get(i).getQuantity()
                                + order.getQuantity());
            }
        }
    }
}
