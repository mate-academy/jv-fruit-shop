package core.basesyntax.operations;

import core.basesyntax.customexceptions.NoRequiredQuantityOfFruits;
import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import java.util.List;

public class Buying implements Operable {
    @Override
    public List<FruitPack> perform(Order order, List<FruitPack> totalPacks) {
        FruitPack orderPack = order.getFruitPack();
        int orderPackQuantity = orderPack.getQuantity();
        for (FruitPack currentPack : totalPacks) {
            if (checkMatching(currentPack, orderPack)) {
                int currentQuantity = currentPack.getQuantity();
                currentPack.setQuantity(reduced(currentPack, orderPack));
                orderPackQuantity -= currentQuantity;
                break;
            }
        }
        if (orderPackQuantity > 0) {
            throw new NoRequiredQuantityOfFruits("Insufficient amount of fruit;(");
        }
        return totalPacks;
    }

    private int reduced(FruitPack currentPack, FruitPack orderPack) {
        return currentPack.getQuantity() > orderPack.getQuantity()
                ? currentPack.getQuantity() - orderPack.getQuantity() : 0;
    }
}
