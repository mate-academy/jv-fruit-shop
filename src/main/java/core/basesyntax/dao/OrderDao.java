package core.basesyntax.dao;

import core.basesyntax.order.Order;

import java.util.List;

public interface OrderDao {
    void add(Order order);

    List<Order> getAll();
}
