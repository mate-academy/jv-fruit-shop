package core.basesyntax.service.parse;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseService {
    List<FruitTransaction> parse(List<String> list);
}
