package core.basesyntax.orderprocessing;

import core.basesyntax.entries.Order;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdersStorage {
    private List<Order> orders = new ArrayList<>();

    public boolean addOrders(List<Order> newOrders) {
        orders.addAll(newOrders);
        orders.sort(Comparator.comparing(Order::getTypeOfOperation).reversed()
                .thenComparing(Order::getFruitPack));
        return true;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
