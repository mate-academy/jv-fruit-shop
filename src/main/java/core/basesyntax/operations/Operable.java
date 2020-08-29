package core.basesyntax.operations;

import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import java.util.List;

public interface Operable {
    List<FruitPack> perform(Order order, List<FruitPack> totalPacks);

    default boolean checkMatching(FruitPack currentPack, FruitPack orderPack) {
        return currentPack.getName().equals(orderPack.getName())
                && currentPack.getExpirationDate().isAfter(orderPack.getExpirationDate());
    }
}
