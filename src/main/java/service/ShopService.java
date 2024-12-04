package service;

import core.basesyntax.FruitTransfer;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransfer> transferList);
}
