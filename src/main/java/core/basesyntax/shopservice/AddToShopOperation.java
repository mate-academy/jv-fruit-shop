package core.basesyntax.shopservice;

import core.basesyntax.DateAndQuantity;
import core.basesyntax.Storage;
import dto.Order;
import java.util.ArrayList;
import java.util.List;

public class AddToShopOperation implements ShopOperation {
    private Storage storage;

    public AddToShopOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void operate(Order order) {
        DateAndQuantity dateAndAmount = new DateAndQuantity(order.getDate(), order.getQuantity());
        if (!storage.getAllProducts()
                .containsKey(order.getProductName())) {
            List<DateAndQuantity> newProductList = new ArrayList<>();
            newProductList.add(dateAndAmount);
            storage.addProductBox(order.getProductName(), newProductList);
            return;
        }
        for (int i = 0; i < storage.getAllProducts().get(order.getProductName()).size(); i++) {
            if (helper(order).get(i).getDate()
                    .isEqual(dateAndAmount.getDate())) {
                helper(order).get(i)
                        .setQuantity(helper(order).get(i)
                                .getQuantity()
                                + order.getQuantity());
                storage.addProductBox(order.getProductName(), helper(order));
                return;
            }
            if (helper(order).get(i).getDate().isAfter(dateAndAmount.getDate())) {
                helper(order).add(i, dateAndAmount);
                storage.addProductBox(order.getProductName(), helper(order));
                return;
            }
        }
        helper(order).add(dateAndAmount);
        storage.addProductBox(order.getProductName(), helper(order));
    }

    private List<DateAndQuantity> helper(Order order) {
        return storage.getAllProducts()
                .get(order.getProductName());
    }
}
