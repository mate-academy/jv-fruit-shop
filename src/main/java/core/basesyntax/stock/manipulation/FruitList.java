package core.basesyntax.stock.manipulation;

import core.basesyntax.stock.order.Order;
import java.util.List;
import java.util.stream.Collectors;

public class FruitList {
    public List<String> createListOfFruit(List<Order> result) {
        return result.stream()
                .map(Order::getTypeOfFruit)
                .distinct()
                .collect(Collectors.toList());
    }
}
