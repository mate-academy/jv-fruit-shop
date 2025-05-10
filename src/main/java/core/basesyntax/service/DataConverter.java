package core.basesyntax.service;

import core.basesyntax.model.ShopOperation;
import java.util.List;

public interface DataConverter {
    List<ShopOperation> convertToOperation(List<String> reportList);
}
