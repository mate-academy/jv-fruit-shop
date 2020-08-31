package core.basesyntax.util;

import core.basesyntax.model.Order;
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
