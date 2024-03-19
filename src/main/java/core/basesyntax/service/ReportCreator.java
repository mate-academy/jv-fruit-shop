package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import java.util.List;

public interface ReportCreator {
    List<String> create(FruitStorage storage);
}
