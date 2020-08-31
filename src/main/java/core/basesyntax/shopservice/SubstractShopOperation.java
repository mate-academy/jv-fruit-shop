package core.basesyntax.shopservice;

import core.basesyntax.DateAndQuantity;
import core.basesyntax.Storage;
import dto.Order;
import java.util.List;

public class SubstractShopOperation implements ShopOperation {
    private Storage storage;

    public SubstractShopOperation(Storage storage) {
        this.storage = storage;
    }

    private List<DateAndQuantity> helper(Order order) {
        return storage.getAllProducts()
                .get(order.getProductName());
    }

    @Override
    public void operate(Order order) {
        int fruitsToSell = 0;
        int counter = 0;
        if (!storage.getAllProducts()
                .containsKey(order.getProductName())) {
            throw new RuntimeException("We do not have this product right now!");
        }
        for (int i = 0; i < helper(order).size(); i++) {
            if (order.getDate().isBefore(helper(order).get(i).getDate())) {
                fruitsToSell = fruitsToSell + helper(order).get(i).getQuantity();
            }
        }
        if (fruitsToSell < order.getQuantity()) {
            throw new RuntimeException("We don't have enough Products!");
        } else {
            while (order.getQuantity() > 0) {
                if (helper(order).get(counter).getQuantity() > order.getQuantity()) {
                    helper(order).get(counter)
                            .setQuantity(helper(order).get(counter).getQuantity()
                                    - order.getQuantity());
                    order.setQuantity(0);
                } else {
                    order.setQuantity(order.getQuantity()
                            - helper(order).get(counter).getQuantity());
                    helper(order).get(counter).setQuantity(0);
                }
                counter++;
            }
        }
        int productAmount = 0;
        for (int i = 0; i < helper(order).size(); i++) {
            productAmount = productAmount + helper(order).get(i).getQuantity();
        }
        if (productAmount == 0) {
            storage.removeProductBox(order.getProductName(), helper(order));
        }
    }
}
