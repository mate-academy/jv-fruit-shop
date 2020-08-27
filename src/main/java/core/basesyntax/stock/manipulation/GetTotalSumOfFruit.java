package core.basesyntax.stock.manipulation;

import core.basesyntax.stock.order.Order;
import java.util.List;

public class GetTotalSumOfFruit {
    public int sum(List<Order> supplyList, String fruit) {
        return supplyList.stream()
                .filter(x -> x.getTypeOfFruit().equals(fruit))
                .map(x -> x.getTypeOfOperation().equals("b")
                        ? -(x.getQuantity())
                        : x.getQuantity())
                .reduce(0, Integer::sum);
    }
}
