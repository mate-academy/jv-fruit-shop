package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FormaterService {
    List<FruitTransaction> form(List<String> stringList);
}
