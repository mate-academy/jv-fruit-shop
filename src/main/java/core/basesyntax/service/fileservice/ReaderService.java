package core.basesyntax.service.fileservice;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public interface ReaderService {
    List<FruitTransaction> creatListTransaction(List<String> dataFromFile);
}
