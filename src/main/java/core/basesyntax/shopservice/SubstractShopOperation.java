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

    private List<DateAndQuantity> dateAndAmount(Order order) {
        return storage.getAllProducts()
                .get(order.getProductName());
    }

    @Override
    public void operate(Order order) {
        doWeHaveSuchProduct(order);
        removeProductsFromDB(order);
        removeProductIfNothing(order);
    }

    private void removeProductsFromDB(Order order) {
        int fruitsToSell = 0;
        int counter = 0;
        for (int i = 0; i < dateAndAmount(order).size(); i++) {
            if (order.getDate().isBefore(dateAndAmount(order).get(i).getDate())) {
                fruitsToSell = fruitsToSell + dateAndAmount(order).get(i).getQuantity();
            }
        }
        if (fruitsToSell < order.getQuantity()) {
            throw new RuntimeException("We don't have enough Products!");
        } else {
            while (order.getQuantity() > 0) {
                if (dateAndAmount(order).get(counter).getQuantity() > order.getQuantity()) {
                    dateAndAmount(order).get(counter)
                            .setQuantity(dateAndAmount(order).get(counter).getQuantity()
                                    - order.getQuantity());
                    order.setQuantity(0);
                } else {
                    order.setQuantity(order.getQuantity()
                            - dateAndAmount(order).get(counter).getQuantity());
                    dateAndAmount(order).get(counter).setQuantity(0);
                }
                counter++;
            }
        }
    }

    private void removeProductIfNothing(Order order) {
        int productAmount = 0;
        for (int i = 0; i < dateAndAmount(order).size(); i++) {
            productAmount = productAmount + dateAndAmount(order).get(i).getQuantity();
        }
        if (productAmount == 0) {
            storage.removeProductBox(order.getProductName(), dateAndAmount(order));
        }
    }

    private void doWeHaveSuchProduct(Order order) {
        if (!storage.getAllProducts()
                .containsKey(order.getProductName())) {
            throw new RuntimeException("We do not have this product right now!");
        }
    }
}
