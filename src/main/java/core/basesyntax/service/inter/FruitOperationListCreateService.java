package core.basesyntax.service.inter;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface FruitOperationListCreateService {
    List<FruitOperation> getFruitOperationsList(List<String> lines);
}
