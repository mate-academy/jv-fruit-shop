package core.basesyntax;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.operation.Supply;

import java.util.List;

public class Sum {
    public int sum(List<Supply> supplyList, String fruit) {
        return supplyList.stream()
                .filter(x -> x.getTypeOfFruit().equals(fruit))
                .map(x -> x.getTypeOfOperation().equals("b")
                        ? -(x.getQuantity())
                        : x.getQuantity())
                .reduce(0, Integer::sum);
    }
}
