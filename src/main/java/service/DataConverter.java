package service;

import core.basesyntax.FruitTransfer;
import java.util.List;

public interface DataConverter {
    List<FruitTransfer> convertToTransfer(List<String> inputReport);
}
