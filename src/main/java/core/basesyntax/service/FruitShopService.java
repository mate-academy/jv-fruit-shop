package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

/**
 * Interface responsible for updating data in the fruit shop.
 Contains a single method void updateData() which processes a list of fruit transactions
 to update the fruit shop's data.**/
public interface FruitShopService {
    void updateData(List<FruitTransaction> transactions);
}
