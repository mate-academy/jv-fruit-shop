package core.basesyntax.servise;

import core.basesyntax.model.FruitTransfer;
import java.util.List;

public interface ParseService {
    List<FruitTransfer> parseFruitTransfers(List<String> list);
}
