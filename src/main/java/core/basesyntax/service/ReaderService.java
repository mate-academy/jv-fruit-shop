package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface ReaderService {
    List<FruitRecord> read(String path);
}
