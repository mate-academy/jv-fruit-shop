package core.basesyntax.service;

import core.basesyntax.model.ShopOperation;
import java.util.List;

public interface ShopService {
    void process(List<ShopOperation> operations);
}
