package core.basesyntax.service;

import core.basesyntax.models.FruitTransfer;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransfer> transferList);
}
