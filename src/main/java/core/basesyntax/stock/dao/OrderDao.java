package core.basesyntax.stock.dao;

import core.basesyntax.stock.order.Order;
import java.util.List;

public interface OrderDao {
    List<Order> getAll();
}
