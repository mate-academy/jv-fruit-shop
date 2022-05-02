package core.basesyntax.service;

import core.basesyntax.model.FruitTransfer;

public interface ConvertToFruitTransferService {
    FruitTransfer toFruitTransfer(String readString);
}
