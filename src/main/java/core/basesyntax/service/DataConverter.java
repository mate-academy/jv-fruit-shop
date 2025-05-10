package core.basesyntax.service;

import core.basesyntax.models.FruitTransfer;
import java.util.List;

public interface DataConverter {
    List<FruitTransfer> convertToTransfer(List<String> inputReport);
}
