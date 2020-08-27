package core.basesyntax.dao;

import core.basesyntax.order.Order;
import java.util.List;

public interface OrderDao {
    List<Order> getAll();
}
