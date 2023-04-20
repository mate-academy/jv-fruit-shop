package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Transfer {

    void generateInfo(List<FruitTransaction> info);
}
