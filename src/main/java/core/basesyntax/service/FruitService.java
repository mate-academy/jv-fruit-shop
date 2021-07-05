package core.basesyntax.service;

import core.basesyntax.dto.TransferAction;
import java.util.List;

public interface FruitService {
    void processRequest(List<TransferAction> transferActions);

    String getCurrentStorageState();
}
