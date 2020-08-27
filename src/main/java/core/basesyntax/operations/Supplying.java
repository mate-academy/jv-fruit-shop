package core.basesyntax.operations;

import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import java.util.List;

public class Supplying implements Operable {
    @Override
    public List<FruitPack> perform(Order order, List<FruitPack> totalPacks) {
        if (totalPacks.size() == 0) {
            totalPacks.add(order.getFruitPack());
            return totalPacks;
        }
        FruitPack orderPack = order.getFruitPack();
        for (int i = 0; i < totalPacks.size(); i++) {
            FruitPack currentPack = totalPacks.get(i);
            if (checkMatching(currentPack, orderPack)) {
                currentPack.setQuantity(currentPack.getQuantity() + orderPack.getQuantity());
                break;
            }
            if (i == totalPacks.size() - 1) {
                totalPacks.add(orderPack);
                break;
            }
        }
        return totalPacks;
    }
}
