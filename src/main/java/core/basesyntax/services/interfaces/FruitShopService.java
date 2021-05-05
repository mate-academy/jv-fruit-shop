package core.basesyntax.services.interfaces;

import core.basesyntax.model.dtos.FruitDtoTransaction;
import java.util.List;

public interface FruitShopService {
    void applyTransactions(List<FruitDtoTransaction> fruitDtoTransactions);

    String createReport();
}
